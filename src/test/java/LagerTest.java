import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class LagerTest {

    public static class LagerConstructorTest {

        @Test
        public void testLagerDefaultConstrucutor() {
            Lager lager = new Lager();
            assertEquals(10, lager.getLagerGroesse());
            assertEquals(0, lager.getArtikelAnzahl());
        }

        @Test
        public void testLagerSecondConstructor() {
            Lager lager = new Lager(4);
            assertEquals(4, lager.getLagerGroesse());
            assertEquals(0, lager.getArtikelAnzahl());
        }

        @Test
        public void testExceptionHandling() {
            Assertions.assertDoesNotThrow(() -> new Lager());
            Assertions.assertThrows(Exception.class, () -> {
                new Lager(0);
            });
            Assertions.assertThrows(Exception.class, () -> {
                new Lager(-1);
            });
        }
    }

}
