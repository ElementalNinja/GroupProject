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
}
