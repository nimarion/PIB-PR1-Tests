import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Testet die MathFunctions Klasse")
public class MathFunctionsTest {

    @DisplayName("Teste Teilersummenberechnung ")
    @Test
    public void testTeilersumme() {
        assertEquals(2, MathFunctions.berechneTeilersumme(1));
        assertEquals(3, MathFunctions.berechneTeilersumme(2));
        assertEquals(4, MathFunctions.berechneTeilersumme(3));
        assertEquals(7, MathFunctions.berechneTeilersumme(4));
        assertEquals(6, MathFunctions.berechneTeilersumme(5));
        assertEquals(12, MathFunctions.berechneTeilersumme(6));
        assertEquals(8, MathFunctions.berechneTeilersumme(7));
        assertEquals(15, MathFunctions.berechneTeilersumme(8));
        assertEquals(13, MathFunctions.berechneTeilersumme(9));
        assertEquals(18, MathFunctions.berechneTeilersumme(10));
        assertEquals(12, MathFunctions.berechneTeilersumme(11));
        assertEquals(28, MathFunctions.berechneTeilersumme(12));
        assertEquals(14, MathFunctions.berechneTeilersumme(13));
        assertEquals(24, MathFunctions.berechneTeilersumme(14));
        assertEquals(24, MathFunctions.berechneTeilersumme(15));
        assertEquals(31, MathFunctions.berechneTeilersumme(16));
        assertEquals(18, MathFunctions.berechneTeilersumme(17));
        assertEquals(39, MathFunctions.berechneTeilersumme(18));
        assertEquals(20, MathFunctions.berechneTeilersumme(19));
        assertEquals(42, MathFunctions.berechneTeilersumme(20));
        assertEquals(32, MathFunctions.berechneTeilersumme(21));
        assertEquals(36, MathFunctions.berechneTeilersumme(22));
        assertEquals(24, MathFunctions.berechneTeilersumme(23));
        assertEquals(60, MathFunctions.berechneTeilersumme(24));
        assertEquals(31, MathFunctions.berechneTeilersumme(25));
    }

    @Test
    public void testLowerThanOne() {
        Assertions.assertThrows(Throwable.class, () -> {
            MathFunctions.berechneTeilersumme(0);
        });
    }

    @Test
    public void testNegativeNumber() {
        Assertions.assertThrows(Throwable.class, () -> {
            MathFunctions.berechneTeilersumme(-1);
        });
    }

    @Test
    public void testWrongLength() {
        Assertions.assertThrows(Throwable.class, () -> {
            MathFunctions.berechneChecksummeIsbn(12345678);
        });
        Assertions.assertThrows(Throwable.class, () -> {
            MathFunctions.berechneChecksummeIsbn(1234567890);
        });
    }

    @Test
    public void testIsbn() {
        assertEquals("0", MathFunctions.berechneChecksummeIsbn(386680192));
        assertEquals("9", MathFunctions.berechneChecksummeIsbn(383622862));
        assertEquals("X", MathFunctions.berechneChecksummeIsbn(123456789));
    }

}
