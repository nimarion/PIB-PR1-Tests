import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PatientenWarteschlageTest {

    @Test
    public void testWarteschlange() {
        PatientenWarteschlange patientenWarteschlange = new PatientenWarteschlange(10);
        patientenWarteschlange.neuerPatient(4711, "Löw, Jogi");
        patientenWarteschlange.neuerPatient(1234, "Kroos, Toni");
        patientenWarteschlange.neuerPatient(1111, "Neuer, Manuel");
        patientenWarteschlange.neuerPatient(2222, "Gnabry, Serge");
        assertEquals(4711, patientenWarteschlange.derNaechsteBitte().getNumber());
        assertEquals(1111, patientenWarteschlange.entfernePatient(1111).getNumber());
        assertEquals(1234, patientenWarteschlange.derNaechsteBitte().getNumber());
    }

    @Test
    public void testConstructor() {
        Assertions.assertThrows(Throwable.class, () -> {
            new PatientenWarteschlange(0);
        });
        Assertions.assertThrows(Throwable.class, () -> {
            new PatientenWarteschlange(-1);
        });
    }

    @Test
    public void testOverflow() {
        PatientenWarteschlange patientenWarteschlange = new PatientenWarteschlange(2);
        Assertions.assertDoesNotThrow(() -> {
            patientenWarteschlange.neuerPatient(4711, "Löw, Jogi");
        });
        Assertions.assertDoesNotThrow(() -> {
            patientenWarteschlange.neuerPatient(1234, "Kroos, Toni");
        });
        Assertions.assertThrows(Throwable.class, () -> {
            patientenWarteschlange.neuerPatient(1111, "Neuer, Manuel");
        });
    }

}
