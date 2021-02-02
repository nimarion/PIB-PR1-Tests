import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PersonQueueTest {

    @Test
    public void testConstructor() {
        Assertions.assertThrows(Exception.class, () -> {
            new StringQueue(-1);
        });
        Assertions.assertThrows(Exception.class, () -> {
            new PersonQueue(0);
        });
        Queue queue = new PersonQueue();
        assertEquals(0, queue.size());
        assertEquals(true, queue.empty());
        assertEquals(false, queue.full());
    }

    @Test
    public void testAddLast() {
        Queue queue = new PersonQueue();
        queue.addLast(new Person("Niklas", "M"));
        queue.addLast(new Person("Simon", "M"));
        queue.addLast(new Person("Jonas", "M"));
        assertEquals("Niklas", ((Person)queue.get(0)).getVorname());
        assertEquals("Simon", ((Person) queue.get(1)).getVorname());
        assertEquals("Jonas", ((Person) queue.get(2)).getVorname());
        assertEquals("Niklas", ((Person) queue.removeFirst()).getVorname());
        assertEquals("Simon", ((Person) queue.get(0)).getVorname());
        assertEquals(2, queue.size());
        assertEquals(false, queue.empty());
        assertEquals(false, queue.full());
    }

    @Test
    public void testCast() {
        Queue queue = new PersonQueue();
        Assertions.assertThrows(Exception.class, () -> {
            queue.addLast(3);
        });
        Assertions.assertThrows(Exception.class, () -> {
            queue.addLast("Niklas");
        });
    }

    @Test
    public void testOverflow() {
        Queue queue = new PersonQueue(3);
        queue.addLast(new Person("Niklas", "M"));
        queue.addLast(new Person("Simon", "M"));
        queue.addLast(new Person("Jonas", "M"));
        assertEquals(true, queue.full());
        Assertions.assertThrows(Exception.class, () -> {
            queue.addLast(new Person("Marc", "M"));
        });
    }

    @Test
    public void testRemoveEmpty(){
        Queue queue = new PersonQueue();
        Assertions.assertThrows(Exception.class, () -> {
            queue.removeFirst();
        });
    }
}
