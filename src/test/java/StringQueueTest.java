import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class StringQueueTest {

    @Test
    public void testConstructor() {
        Assertions.assertThrows(Exception.class, () -> {
            new StringQueue(-1);
        });
        Assertions.assertThrows(Exception.class, () -> {
            new PersonQueue(0);
        });
        Queue queue = new StringQueue();
        assertEquals(0, queue.size());
        assertEquals(true, queue.empty());
        assertEquals(false, queue.full());
    }

    @Test
    public void testAddLast() {
        Queue queue = new StringQueue();
        queue.addLast("Hallo");
        queue.addLast("Welt");
        queue.addLast("!");
        assertEquals("Hallo", queue.get(0));
        assertEquals("Welt", queue.get(1));
        assertEquals("!", queue.get(2));
        assertEquals("Hallo", queue.removeFirst());
        assertEquals("Welt", queue.get(0));
        assertEquals(2, queue.size());
        assertEquals(false, queue.empty());
        assertEquals(false, queue.full());
    }

    @Test
    public void testCast() {
        Queue queue = new StringQueue();
        Assertions.assertThrows(Exception.class, () -> {
            queue.addLast(3);
        });
        Assertions.assertThrows(Exception.class, () -> {
            queue.addLast(Long.valueOf("3"));
        });
    }

    @Test
    public void testOverflow() {
        Queue queue = new StringQueue(3);
        queue.addLast("Niklas");
        queue.addLast("Simon");
        queue.addLast("Jonas");
        assertEquals(true, queue.full());
        Assertions.assertThrows(Exception.class, () -> {
            queue.addLast("Marc");
        });
    }

    @Test
    public void testRemoveEmpty(){
        Queue queue = new StringQueue();
        Assertions.assertThrows(Exception.class, () -> {
            queue.removeFirst();
        });
    }
}
