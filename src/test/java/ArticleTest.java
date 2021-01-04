import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ArticleTest {

    public static class ArticleMethodsTest {

        @Test
        public void testAbbuchen() {
            Artikel artikel = getArtikel();
            Assertions.assertThrows(Throwable.class, () -> {
                artikel.bucheAbgang(101);
            });
            Assertions.assertThrows(Throwable.class, () -> {
                artikel.bucheAbgang(-10);
            });
            artikel.bucheAbgang(50);
            assertEquals(50, artikel.getBestand());
            artikel.bucheAbgang(1);
            assertEquals(49, artikel.getBestand());
            Assertions.assertDoesNotThrow(() -> artikel.bucheAbgang(49));
        }

        @Test
        public void testZugang() {
            Artikel artikel = getArtikel();
            Assertions.assertThrows(Throwable.class, () -> {
                artikel.bucheZugang(-10);
            });
            artikel.bucheZugang(10);
            assertEquals(110, artikel.getBestand());
            artikel.bucheZugang(1);
            assertEquals(111, artikel.getBestand());
        }

        @Test
        public void testChangeArt() {
            Artikel artikel = getArtikel();
            artikel.setArt("Limo");
            assertEquals("Limo", artikel.getArt());
            artikel.setArt("  Limo ");
            assertEquals("Limo", artikel.getArt());

            Assertions.assertThrows(Throwable.class, () -> {
                artikel.setArt("");
            });
            Assertions.assertThrows(Throwable.class, () -> {
                artikel.setArt("  ");
            });
            Assertions.assertThrows(Throwable.class, () -> {
                artikel.setArt(null);
            });
        }

        @Test
        public void testSetPrice() {
            Artikel artikel = getArtikel();
            Assertions.assertThrows(Throwable.class, () -> {
                artikel.setPreis(0);
            });
            Assertions.assertThrows(Throwable.class, () -> {
                artikel.setPreis(-1);
            });
            artikel.setPreis(3);
            assertEquals(3, artikel.getPreis());
        }

        private Artikel getArtikel() {
            return new Artikel(1234, "Coca Cola", 100, 1);
        }

    }

    public static class ArticleConstructorTest {

        @Test
        public void testArtikel() {
            Artikel artikel = new Artikel(1234, "Coca Cola", 4,1.3);
            assertEquals(1234, artikel.getArtikelNr());
            assertEquals("Coca Cola", artikel.getArt());
            assertEquals(4, artikel.getBestand());
            assertEquals(1.3, artikel.getPreis());
        }

        @Test
        public void testArticleSecondConstructor() {
            Artikel artikel = new Artikel(1234, "Limo", 1.4);
            assertEquals(1234, artikel.getArtikelNr());
            assertEquals("Limo", artikel.getArt());
            assertEquals(0, artikel.getBestand());
            assertEquals(1.4, artikel.getPreis());
        }

        @Test
        public void testArticleConstructorNegativeBestand() {
            Assertions.assertThrows(Throwable.class, () -> {
                new Artikel(1234, "Coca Cola", -10, 1);
            });
        }

        @Test
        public void testArticleConstructorNegativePrice() {
            Assertions.assertThrows(Throwable.class, () -> {
                new Artikel(1234, "Coca Cola", 1, -1);
            });
            Assertions.assertThrows(Throwable.class, () -> {
                new Artikel(1234, "Coca Cola", 1, 0);
            });
        }

        @Test
        public void testArticleConstructorWrongArticleNumber() {
            Assertions.assertThrows(Throwable.class, () -> {
                new Artikel(123, "Coca Cola", 10);
            });
            Assertions.assertThrows(Throwable.class, () -> {
                new Artikel(12345, "Coca Cola", 10);
            });
            Assertions.assertThrows(Throwable.class, () -> {
                new Artikel(999, "Coca Cola", 10);
            });
        }

        @Test
        public void testArticleConstructorEmptyArt() {
            Assertions.assertThrows(Throwable.class, () -> {
                new Artikel(1234, "", 0);
            });
            Assertions.assertThrows(Throwable.class, () -> {
                new Artikel(1234, " ", 0);
            });
            Assertions.assertThrows(Throwable.class, () -> {
                new Artikel(1234, null, 0);
            });
        }

        @Test
        public void testArticleConstructorLeadingWhiteSpaces() {
            Artikel artikel = new Artikel(1234, "    Limo   ", 3);
            assertEquals("Limo", artikel.getArt());
        }
    }

    public static class ArticleToStringTest {

        @Test
        public void testToString() {
            Artikel artikel = new Artikel(1234, "Coca Cola", 5.3);
            assertEquals("Artikel: 1234 Art: Coca Cola Bestand: 0 Preis: 5.3", artikel.toString());
        }
    }
}
