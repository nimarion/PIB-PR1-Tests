import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BuchTest {

    @Test
    public void testConstructor(){
        Assertions.assertThrows(Exception.class, () -> {
            new Buch(3333, 1, 3.5, "", "Eine Woche voller Samstage", "Oettinger");
        });
        Assertions.assertThrows(Exception.class, () -> {
            new Buch(3333, 1, 3.5, null, "Eine Woche voller Samstage", "Oettinger");
        });
        Assertions.assertThrows(Exception.class, () -> {
            new Buch(3333, 1, 3.5, "Paul Maar", "", "Oettinger");
        });
        Assertions.assertThrows(Exception.class, () -> {
            new Buch(3333, 1, 3.5, "Paul Maar", null, "Oettinger");
        });
        Assertions.assertThrows(Exception.class, () -> {
            new Buch(3333, 1, 3.5, "Paul Maar", "Eine Woche voller Samstage", "");
        });
        Assertions.assertThrows(Exception.class, () -> {
            new Buch(3333, 1, 3.5, "Paul Maar", "Eine Woche voller Samstage", null);
        });
        Buch buch = new Buch(3333, 1, 3.5, "Paul Maar", "Eine Woche voller Samstage", "Oettinger");
        assertEquals("Eine Woche voller Samstage", buch.getTitel());
        assertEquals("Paul Maar", buch.getAutor());
        assertEquals("Oettinger", buch.getVerlag());
    }
    
}
