import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.Assert.assertEquals;
import static java.time.Duration.ofMillis;

@DisplayName("Testet die Laufzeit der Teilerberechnung")
public class MathFunctionsTimeTest {

    @Test
    public void testBigInput() {
        long result = assertTimeoutPreemptively(ofMillis(50), () -> {
            return MathFunctions.berechneTeilersumme(9999999999L);
        });
        assertEquals(result, 16203253248L);
    }

    @Test
    public void testBigPrime() {
        long result = assertTimeoutPreemptively(ofMillis(100), () -> {
            return MathFunctions.berechneTeilersumme(5600748293801L);
        });
        assertEquals(result, 5600748293802L);
    }

    public static class PotenzTimeTest {

        @Test
        public void testBigLoop() {
            assertTimeoutPreemptively(ofMillis(260), () -> {
                for (int i = 1; i <= 10000; i++) {
                    MathFunctions.istSummeVonPotenzen(i);
                }
            });
        }
    }

}
