package com.napier.sem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    @Test
    void getenv_returnsFallbackWhenEnvMissing() {
        String value = App.getenv("THIS_ENV_SHOULD_NOT_EXIST_12345", "default");
        assertEquals("default", value);
    }

    @Test
    void getenv_usesEnvWhenPresent() {
        String path = App.getenv("PATH", "fallback");
        assertNotNull(path);
        assertNotEquals("fallback", path);
    }

    @Test
    void readResource_loadsExistingSqlFile() {
        String sql = App.readResource("UseCases/1_AllCountriesOrdered.sql");

        assertNotNull(sql);
        assertFalse(sql.isBlank(), "SQL should not be empty");
        assertTrue(sql.toLowerCase().contains("select"), "SQL should contain SELECT");
    }

    @Test
    void redResource_throwsForMissingFile() {
        assertThrows(RuntimeException.class, () -> App.readResource("UseCases/notarealfile.sql"));
    }
}
