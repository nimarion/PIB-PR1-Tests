import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class LagerTest {

    public static class LagerMethodsTest {

        @Test
        public void testAnlegen() {
            Lager lager = getLager();
            lager.legeAnArtikel(new Artikel(3333, "Coca Cola", 3));
            assertEquals(10, lager.getLagerGroesse());
            assertEquals(1, lager.getArtikelAnzahl());
            lager.legeAnArtikel(new Artikel(4444, "Limo", 3));
            assertEquals(2, lager.getArtikelAnzahl());
        }

        @Test
        public void testLagerOverflow() {
            Lager lager = getLager();
            Assertions.assertThrows(Exception.class, () -> {
                for (int i = 1000; i <= 1010; i++) {
                    lager.legeAnArtikel(new Artikel(i, "Coca", 3));
                }
            });
        }

        @Test
        public void testLagerDuplicateArticle() {
            Lager lager = getLager();
            Assertions.assertDoesNotThrow(() -> {
                lager.legeAnArtikel(new Artikel(3333, "Coca Cola", 3));
            });
            Assertions.assertDoesNotThrow(() -> {
                lager.legeAnArtikel(new Artikel(4444, "Coca Cola", 3));
            });
            Assertions.assertThrows(Exception.class, () -> {
                lager.legeAnArtikel(new Artikel(3333, "Coca Cola", 3));
            });
        }

        @Test
        public void testRemove() {
            Lager lager = getLager();
            lager.legeAnArtikel(new Artikel(3333, "Coca Cola", 3));
            assertEquals(1, lager.getArtikelAnzahl());
            lager.legeAnArtikel(new Artikel(5555, "Limo", 3));
            assertEquals(2, lager.getArtikelAnzahl());
            lager.entferneArtikel(3333);
            assertEquals(1, lager.getArtikelAnzahl());
            lager.entferneArtikel(5555);
            assertEquals(0, lager.getArtikelAnzahl());
            lager.entferneArtikel(4444);
            assertEquals(0, lager.getArtikelAnzahl());
        }

        @Test
        public void testZugangAbgang() {
            Lager lager = getLager();
            lager.legeAnArtikel(new Artikel(3333, "Coca Cola", 3));
            lager.bucheZugang(3333, 4);
            assertEquals(4, lager.getArtikelByNr(3333).getBestand());
            lager.bucheAbgang(3333, 2);
            assertEquals(2, lager.getArtikelByNr(3333).getBestand());
        }

        @Test
        public void testZugangAbgangException() {
            Lager lager = getLager();
            Assertions.assertThrows(Exception.class, () -> {
                lager.bucheZugang(3333, 4);
            });
            Assertions.assertThrows(Exception.class, () -> {
                lager.bucheAbgang(3333, 4);
            });
        }

        @Test
        public void testIndexGetter() {
            Lager lager = getLager();
            lager.legeAnArtikel(new Artikel(3333, "Coca Cola", 3));
            lager.legeAnArtikel(new Artikel(5555, "Limo", 3));
            assertEquals(3333, lager.getArtikel(0).getArtikelNr());
            assertEquals(5555, lager.getArtikel(1).getArtikelNr());
            Assertions.assertThrows(Exception.class, () -> {
                assertNull(lager.getArtikel(-1));
            });
            Assertions.assertThrows(Exception.class, () -> {
                assertNull(lager.getArtikel(10));
            });
            assertNull(lager.getArtikel(9));
        }

        @Test
        public void testPriceChange() {
            Lager lager = new Lager();
            lager.legeAnArtikel(new Artikel(3333, "Coca Cola", 3));
            lager.legeAnArtikel(new Artikel(5555, "Limo", 4));

            lager.aenderePreisAllerArtikel(4);
            assertEquals(3.12, lager.getArtikel(0).getPreis());
            assertEquals(4.16, lager.getArtikel(1).getPreis());

            lager.aenderePreisAllerArtikel(25.5);
            assertEquals(3.92, lager.getArtikel(0).getPreis());
            assertEquals(5.22, lager.getArtikel(1).getPreis());

            lager.aenderePreisAllerArtikel(-25.5);
            assertEquals(2.92, lager.getArtikel(0).getPreis());
            assertEquals(3.89, lager.getArtikel(1).getPreis());

            lager.aenderePreisAllerArtikel(-100);
            assertEquals(2.92, lager.getArtikel(0).getPreis());
            assertEquals(3.89, lager.getArtikel(1).getPreis());
        }

        private Lager getLager() {
            return new Lager();
        }
    }

    public static class LagerConstructorTest {

        @Test
        public void testDefaultConstructor() {
            Lager lager = new Lager();
            assertEquals(10, lager.getLagerGroesse());
            assertEquals(0, lager.getArtikelAnzahl());
        }

        @Test
        public void testSecondConstructor() {
            Lager lager = new Lager(34);
            assertEquals(34, lager.getLagerGroesse());
            assertEquals(0, lager.getArtikelAnzahl());
        }

        @Test
        public void testNegativeSize() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                new Lager(0);
            });
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                new Lager(-1);
            });
        }

    }

}
