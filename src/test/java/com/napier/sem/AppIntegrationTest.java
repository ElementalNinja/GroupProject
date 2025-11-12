package com.napier.sem;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest {

    private static Connection con;

    @BeforeAll
    static void initConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String host = env("DB_HOST", "127.0.0.1");
        String port = env("DB_PORT", "3306");
        String db   = env("DB_NAME", "world");
        String user = env("DB_USER", "root");
        String pass = env("DB_PASSWORD", "example");

        String url = "jdbc:mysql://" + host + ":" + port + "/" + db
                + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        // Attempt connection with the corrected port
        con = DriverManager.getConnection(url, user, pass);
        assertNotNull(con, "DB connection should be established");
    }

    @AfterAll
    static void closeConnection() throws Exception {
        if (con != null && !con.isClosed()) {
            con.close();
        }
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

    private static String env(String k, String d) {
        String v = System.getenv(k);
        return (v == null || v.isBlank()) ? d : v;
    }
}