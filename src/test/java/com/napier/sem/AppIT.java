package com.napier.sem;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Base integration test class. Verifies core database connection and setup.
 */

public class AppIT {
    // Connection object shared by all tests.
    private static Connection con;
    /**
     * Executes once before all tests. Establishes DB connection.
     */
    @BeforeAll
    static void initConnection() throws Exception {
        // Load MySQL JDBC driver.
        Class.forName("com.mysql.cj.jdbc.Driver");

        String host = env("DB_HOST", "127.0.0.1");
        String port = env("DB_PORT", "33060");
        String db   = env("DB_NAME", "world");
        String user = env("DB_USER", "root");
        String pass = env("DB_PASSWORD", "example");

        String url = "jdbc:mysql://" + host + ":" + port + "/" + db
                + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

// --- CONNECTION RETRY LOGIC ---
        int retries = 10;
        int waitTime = 3000; // 3 seconds wait between attempts

        for (int i = 0; i < retries; i++) {
            try {
                // Attempt connection using the URL
                con = DriverManager.getConnection(url, user, pass);
                System.out.println("Database connection established successfully on attempt " + (i + 1));
                break; // Exit loop if successful
            } catch (Exception e) {
                System.err.println("DB Connection failed on attempt " + (i + 1) + ". Retrying in " + waitTime / 1000 + "s. Error: " + e.getMessage());
                if (i == retries - 1) {
                    // Re-throw the exception on the final attempt
                    throw e;
                }
                // Wait before next attempt
                Thread.sleep(waitTime);
            }
        }
        // --- End Retry Logic ---

        // Final assertion: This confirms the loop succeeded.
        assertNotNull(con, "FATAL: Failed to establish DB connection after " + retries + " attempts. Hostname resolution failed.");
    }
    /**
     * Executes once after all tests. Closes DB connection.
     */
    @AfterAll
    static void closeConnection() throws Exception {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
    /**
     * Verifies the database is connected and contains data.
     */
    @Test
    void testDatabaseHasCities() throws Exception {
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM city")) {
            assertTrue(rs.next());
            int count = rs.getInt(1);
            assertTrue(count > 0, "City table should not be empty");
        }
    }
    /**
     * Helper to read system environment variables or use a default value.
     */
    private static String env(String k, String d) {
        String v = System.getenv(k);
        return (v == null || v.isBlank()) ? d : v;
    }
}