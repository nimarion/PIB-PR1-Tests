import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class VideoTest {

    @Test
    public void testConstructor(){
        Assertions.assertThrows(Exception.class, () -> {
            new Video(3333, 1, 3.5, "", 3, 1980);
        });
        Assertions.assertThrows(Exception.class, () -> {
            new Video(3333, 1, 3.5, null, 3, 1980);
        });
        Assertions.assertThrows(Exception.class, () -> {
            new Video(3333, 1, 3.5, "Avengers", 3, 1949);
        });
        Assertions.assertThrows(Exception.class, () -> {
            new Video(3333, 1, 3.5, "Avengers", 3, 2021);
        });
        Assertions.assertThrows(Exception.class, () -> {
            new Video(3333, 1, 3.5, "Avengers", 0, 1980);
        });
        Video video = new Video(3333, 1000, 17.5, "Avengers", 350, 2019);
        assertEquals("Avengers", video.getTitel());
        assertEquals(350, video.getSpieldauer());
        assertEquals(2019, video.getJahr());
    }
    
}
