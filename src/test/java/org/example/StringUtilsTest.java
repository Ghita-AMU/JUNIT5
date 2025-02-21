package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)


class StringUtilsTest {
    private long startTime;


    //Exo3
    @BeforeEach
    void BeforeEach() {
        System.out.println("Avant chaque test");
    }

    @AfterEach
    void tearAfterEach() {
        System.out.println("Après chaque test");
    }

    @BeforeAll
    static void BeforeAll() {
        System.out.println("Une seule fois avant tous les tests");
    }

    @AfterAll
    static void AfterAll() {
        System.out.println("Une seule fois après tous les tests");
    }


// Exo4
    @Test
    void testReverse() {
        System.out.println("Exécution du test Reverse: ");
        assertEquals("jupe", StringUtils.reverse("epuj"));
        assertEquals("ba", StringUtils.reverse("ab"));
        assertEquals("", StringUtils.reverse(""));
        assertNull(StringUtils.reverse(null)); //cas null
    }

    @Test
    void testCapitalize() {
        System.out.println("Exécution du test Capitalize:");
        assertEquals("Z", StringUtils.capitalize("z"));
        assertEquals("Hey", StringUtils.capitalize("hey"));
        assertEquals("", StringUtils.reverse(""));
        assertNull(StringUtils.reverse(null)); //cas null
    }

    // Test avec plusieurs assertions en une seule méthode
    @Test
    void testAssertionsUtilitaires() {
        assertAll("Test de plusieurs valeurs en une seule assertion",
                () -> assertEquals("tset", StringUtils.reverse("test")),
                () -> assertEquals("Hey", StringUtils.capitalize("hey")),
                () -> assertEquals("09", StringUtils.reverse("90"))
        );
    }
//Assertions avancées
    @Test
    void testAssertionsAvancees() {
        assertDoesNotThrow(() -> StringUtils.reverse("Hey"));
        assertTrue(StringUtils.reverse("Test").length() > 0);
        assertNotNull(StringUtils.capitalize("java"));
    }
    //Exo5
    @ParameterizedTest
    @ValueSource(strings = {"apple", "banana", "pear"})
    void testReverseWithValueSource(String input) {
        String reversed = StringUtils.reverse(input);
        assertEquals(new StringBuilder(input).reverse().toString(), reversed);
    }
    //Test de la méthode capitalize() avec des val paramétrées
    @ParameterizedTest
    @CsvSource({
            "apple, elppa",
            "banana, ananab",
            "pear, raep"
    })
    void testReverseWithCsvSource(String input, String expected) {
        String reversed = StringUtils.reverse(input);
        assertEquals(expected, reversed);
    }


    @ParameterizedTest
    @CsvSource({
            "z, Z",
            "hey, Hey",
            "test, Test"
    })
    void testCapitalizeWithCsvSource(String input, String expected) {
        String result = StringUtils.capitalize(input);
        assertEquals(expected, result);
    }

    //Exo6
    // Méthode lente pour tester la performance
    public String reverse(String input) {
        try {
            Thread.sleep(50); // Simuler un délai de 50ms
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return new StringBuilder(input).reverse().toString();
    }

    // Tester la performance de la méthode reverse
    @Test
    void testReversePerformance() {
        String input = "javatesttestjavatestjavatestjava".repeat(1000);

        long startTime = System.nanoTime();
        String reversed = reverse(input);
        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        System.out.println("Durée d'exécution : " + (duration / 1_000_000.0) + " ms");
     // Vérifie que la méthode prend moins de 100 ms
        assertTrue(duration < 100_000_000, "La méthode doit s'exécuter en moins de 100 ms");
    }
}
