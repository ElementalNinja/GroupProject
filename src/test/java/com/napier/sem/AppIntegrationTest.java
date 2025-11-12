package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Integration test for App: checks MySQL connectivity and simple query.
 */
public class AppIntegrationTest {

    private static Connection con;

    @BeforeAll
    static void initConnection() throws Exception {
        String host = getenv("DB_HOST", "127.0.0.1");
        String port = getenv("DB_PORT", "33060");
        String db   = getenv("DB_NAME", "world");
        String user = getenv("DB_USER", "root");
        String pass = getenv("DB_PASSWORD", "example");

        String url = "jdbc:mysql://" + host + ":" + port + "/" + db +
                "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        con = DriverManager.getConnection(url, user, pass);
        assertNotNull(con);
    }

    @AfterAll
    static void closeConnection() throws Exception {
        if (con != null && !con.isClosed())
            con.close();
    }

    @Test
    void testDatabaseHasCities() throws Exception {
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM city")) {
            assertTrue(rs.next());
            int count = rs.getInt(1);
            assertTrue(count > 0, "City table should not be empty");
        }
    }

    @Test
    void testWesternEuropeCapitalsOrdered() throws Exception {
        String sql = """
            SELECT city.Name, city.Population
            FROM country JOIN city ON country.Capital = city.ID
            WHERE country.Region = 'Western Europe'
            ORDER BY city.Population DESC
        """;
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            int rows = 0;
            int prev = Integer.MAX_VALUE;
            while (rs.next()) {
                rows++;
                int pop = rs.getInt("Population");
                assertTrue(pop <= prev, "Population not in descending order");
                prev = pop;
            }
            assertEquals(9, rows, "Western Europe should have 9 capitals");
        }
    }

    private static String getenv(String key, String fallback) {
        String v = System.getenv(key);
        return (v == null || v.isBlank()) ? fallback : v;
    }
}