package com.napier.sem;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Main application class.
 * Connects to the MySQL database, runs a list of SQL scripts (queries),
 * and prints the results in a readable format.
 */
public class App {
    private Connection con;

    // ---------- Database Connection ----------

    /**
     * Tries to connect to the database using environment variables.
     * Falls back to default values if the variables aren’t set.
     * Keeps trying until the database is ready (up to 30 times).
     */
    private Connection connect() {
        String host = getenv("DB_HOST", "db");     // The container name in docker-compose
        String db   = getenv("DB_NAME", "world");  // Database name
        String user = getenv("DB_USER", "root");   // Login username
        String pass = getenv("DB_PASSWORD", "example"); // Login password

        // Build the JDBC connection string
        String url = "jdbc:mysql://" + host + ":3306/" + db
                + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        int attempts = 30; // Try 30 whole times before giving up
        for (int i = 1; i <= attempts; i++) {
            try {
                // Make sure the JDBC driver is available
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Try to connect
                return DriverManager.getConnection(url, user, pass);
            } catch (Exception e) {
                // Wait one second before retrying (database might still be starting)
                sleep(1000);
            }
        }

        throw new RuntimeException("Could not connect to MySQL at " + url);
    }

    /**
     * Just a helper to pause execution for a short time between retries.
     */
    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {
        }
    }

    /**
     * Reads an environment variable, or returns a default if it’s not set.
     */
    private static String getenv(String key, String fallback) {
        String value = System.getenv(key);
        return (value == null || value.isBlank()) ? fallback : value;
    }

    // ---------- SQL File Reader ----------

    /**
     * Reads an SQL file from the resources folder and returns it as a string.
     */
    private static String readResource(String path) {
        try (InputStream in = App.class.getClassLoader().getResourceAsStream(path)) {
            if (in == null)
                throw new IllegalArgumentException("Missing resource: " + path);

            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(in, StandardCharsets.UTF_8))) {
                return br.lines().collect(Collectors.joining("\n")).trim();
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to read " + path, e);
        }
    }

    // ---------- Result Printer ----------

    /**
     * Prints out the contents of a ResultSet in a basic table format.
     */
    private static void printResultSet(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        int cols = md.getColumnCount();

        // Print header row
        StringBuilder header = new StringBuilder();
        for (int c = 1; c <= cols; c++) {
            header.append(md.getColumnLabel(c));
            if (c < cols) header.append(" | ");
        }
        System.out.println(header);
        System.out.println("-".repeat(header.length()));

        // Print each row of data
        int count = 0;
        while (rs.next()) {
            StringBuilder row = new StringBuilder();
            for (int c = 1; c <= cols; c++) {
                row.append(rs.getString(c));
                if (c < cols) row.append(" | ");
            }
            System.out.println(row);
            count++;
        }

        System.out.println("(rows: " + count + ")\n");
    }

    // ---------- Main Execution ----------

    public static void main(String[] args) throws Exception {
        App app = new App();
        System.out.println("Application started successfully");
        // Connect to the database (this will keep retrying until it’s ready)
        app.con = app.connect();

        // A list of SQL files to run, in order.
        // These files live in src/main/resources/UseCases/
        List<String> files = List.of(
                "UseCases/7_CitiesInWorld.sql",
                "UseCases/8_CitiesInContinent.sql",
                "UseCases/9_CitiesInRegion.sql",
                "UseCases/10_CitiesInCountry.sql",
                "UseCases/11_CitiesInDistrict.sql",
                "UseCases/12_TopPopulatedCities.sql",
                "UseCases/19_CapitalsOrder.sql",
                "UseCases/20_TopPopulatedCapitals.sql",
                "UseCases/21_TopPopulatedCapitalsContinent.sql",
                "UseCases/22_TopPopulatedCapitalsRegion.sql",
                "UseCases/23_PeoplePopulation.sql",
                "UseCases/27_ContinentPopulation.sql",
                "UseCases/35_PeopleInCityVsNotInCountry.sql"
        );

        // Create a Statement object for running SQL commands
        try (Statement st = app.con.createStatement()) {
            for (String f : files) {
                // Read and execute each SQL script
                String sql = readResource(f);
                System.out.println("=== Running " + f + " ===");
                long start = System.nanoTime();

                try (ResultSet rs = st.executeQuery(sql)) {
                    // Print out the results of this query
                    printResultSet(rs);
                }

                long elapsedMs = Duration.ofNanos(System.nanoTime() - start).toMillis();
                System.out.println("Finished in " + elapsedMs + " ms\n");
            }
        }

        // Close the database connection when done
        app.con.close();
    }
}
