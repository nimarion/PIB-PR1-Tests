import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Testet die MathFunctions Klasse")
public class MathFunctionsTest {

    public static class TeilersummeTest {
        @Test
        public void testTeilersumme() {
            assertEquals(1, MathFunctions.berechneTeilersumme(1));
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
            assertEquals(217, MathFunctions.berechneTeilersumme(100));
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
    }

    public static class IsbnTest {
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

    public static class NullstellenTest {
        @Test
        public void testNullstellen() {
            assertEquals("Zwei Nullstellen: -1.0 | -1.5", MathFunctions.berechneNullstellen(2.5, 1.5));
            assertEquals("Doppelte Nullstelle: -1.5", MathFunctions.berechneNullstellen(3.0, 2.25));
            assertEquals("Komplexe Nullstellen", MathFunctions.berechneNullstellen(1.5, 2.5));
        }
    }

    public static class PotenzenTest {
        @Test
        public void testSummeVonPotenzen() {
            Assertions.assertThrows(Throwable.class, () -> {
                MathFunctions.istSummeVonPotenzen(0);
            });
            Assertions.assertThrows(Throwable.class, () -> {
                MathFunctions.istSummeVonPotenzen(-10);
            });
            ;
            assertEquals(false, MathFunctions.istSummeVonPotenzen(1));
            assertEquals(false, MathFunctions.istSummeVonPotenzen(2));
            assertEquals(true, MathFunctions.istSummeVonPotenzen(3));
            assertEquals(false, MathFunctions.istSummeVonPotenzen(4));
            assertEquals(false, MathFunctions.istSummeVonPotenzen(5));
            assertEquals(true, MathFunctions.istSummeVonPotenzen(6));
            assertEquals(false, MathFunctions.istSummeVonPotenzen(7));
            assertEquals(false, MathFunctions.istSummeVonPotenzen(8));
            assertEquals(false, MathFunctions.istSummeVonPotenzen(9));
            assertEquals(true, MathFunctions.istSummeVonPotenzen(10));
            assertEquals(true, MathFunctions.istSummeVonPotenzen(11));
            assertEquals(false, MathFunctions.istSummeVonPotenzen(12));
            assertEquals(true, MathFunctions.istSummeVonPotenzen(13));
            assertEquals(false, MathFunctions.istSummeVonPotenzen(14));
            assertEquals(false, MathFunctions.istSummeVonPotenzen(15));
            assertEquals(false, MathFunctions.istSummeVonPotenzen(16));
            assertEquals(false, MathFunctions.istSummeVonPotenzen(17));
            assertEquals(true, MathFunctions.istSummeVonPotenzen(18));
            assertEquals(false, MathFunctions.istSummeVonPotenzen(19));
            assertEquals(false, MathFunctions.istSummeVonPotenzen(20));
            assertEquals(true, MathFunctions.istSummeVonPotenzen(21));
            assertEquals(false, MathFunctions.istSummeVonPotenzen(22));
            assertEquals(false, MathFunctions.istSummeVonPotenzen(23));
            assertEquals(false, MathFunctions.istSummeVonPotenzen(24));
            assertEquals(true, MathFunctions.istSummeVonPotenzen(25));
            assertEquals(true, MathFunctions.istSummeVonPotenzen(26));
            assertEquals(true, MathFunctions.istSummeVonPotenzen(27));
            assertEquals(true, MathFunctions.istSummeVonPotenzen(28));
            assertEquals(true, MathFunctions.istSummeVonPotenzen(29));
            assertEquals(false, MathFunctions.istSummeVonPotenzen(30));
            assertEquals(false, MathFunctions.istSummeVonPotenzen(31));
            assertEquals(true, MathFunctions.istSummeVonPotenzen(32));
            assertEquals(true, MathFunctions.istSummeVonPotenzen(33));
            assertEquals(true, MathFunctions.istSummeVonPotenzen(34));
            assertEquals(false, MathFunctions.istSummeVonPotenzen(35));
            assertEquals(false, MathFunctions.istSummeVonPotenzen(36));
            assertEquals(true, MathFunctions.istSummeVonPotenzen(37));
            assertEquals(true, MathFunctions.istSummeVonPotenzen(38));
            assertEquals(false, MathFunctions.istSummeVonPotenzen(39));
            assertEquals(true, MathFunctions.istSummeVonPotenzen(40));
            assertEquals(false, MathFunctions.istSummeVonPotenzen(41));
            assertEquals(true, MathFunctions.istSummeVonPotenzen(42));
            assertEquals(false, MathFunctions.istSummeVonPotenzen(43));
            assertEquals(true, MathFunctions.istSummeVonPotenzen(44));
            assertEquals(true, MathFunctions.istSummeVonPotenzen(45));
            assertEquals(false, MathFunctions.istSummeVonPotenzen(46));
            assertEquals(true, MathFunctions.istSummeVonPotenzen(47));
            assertEquals(false, MathFunctions.istSummeVonPotenzen(48));
            assertEquals(true, MathFunctions.istSummeVonPotenzen(49));
            assertEquals(false, MathFunctions.istSummeVonPotenzen(50));
        }

    }

}
