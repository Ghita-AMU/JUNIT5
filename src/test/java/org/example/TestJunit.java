package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestJunit {

    @Test
    void testExample() {
        assertTrue(2 + 2 == 4, "ça doit être égal à 4");
    }
}
