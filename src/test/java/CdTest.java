import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CdTest {

    @Test
    public void testConstructor(){
        Assertions.assertThrows(Exception.class, () -> {
            new CD(3333, 1, 3.5, "", "Oh My My", 16);
        });
        Assertions.assertThrows(Exception.class, () -> {
            new CD(3333, 1, 3.5, null, "Oh My My", 16);
        });
        Assertions.assertThrows(Exception.class, () -> {
            new CD(3333, 1, 3.5, "OneRepublic", "", 16);
        });
        Assertions.assertThrows(Exception.class, () -> {
            new CD(3333, 1, 3.5, "OneRepublic", null, 16);
        });
        Assertions.assertThrows(Exception.class, () -> {
            new CD(3333, 1, 3.5, "OneRepublic", "Oh My My", 0);
        });
        CD cd = new CD(3333, 1, 3.5, "OneRepublic", "Oh My My", 16);
        assertEquals("OneRepublic", cd.getInterpret());
        assertEquals("Oh My My", cd.getTitel());
        assertEquals(16, cd.getAnzahlTitel());
    }
    
}
