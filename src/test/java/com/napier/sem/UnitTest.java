package com.napier.sem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    // This test checks if the program fetches a path that does NOT exist
    // (passes unless it finds something, which it shouldn't
    @Test
    void getenv_returnsFallbackWhenEnvMissing() {
        String value = App.getenv("THIS_ENV_SHOULD_NOT_EXIST_12345", "default");
        assertEquals("default", value);
    }

    // This checks for path in environments (which every environment should have)
    @Test
    void getenv_usesEnvWhenPresent() {
        String path = App.getenv("PATH", "fallback");
        assertNotNull(path);
        assertNotEquals("fallback", path);
    }

    // This test checks if the project can load a SQL file (passes if it finds one)
    @Test
    void readResource_loadsExistingSqlFile() {
        String sql = App.readResource("UseCases/1_AllCountriesOrdered.sql");

        assertNotNull(sql);
        assertFalse(sql.isBlank(), "SQL should not be empty");
        assertTrue(sql.toLowerCase().contains("select"), "SQL should contain SELECT");
    }

    // This test checks if the program can open a file that doesn't exist (which it shouldn't be able to)
    @Test
    void redResource_throwsForMissingFile() {
        assertThrows(RuntimeException.class, () -> App.readResource("UseCases/notarealfile.sql"));
    }
}
