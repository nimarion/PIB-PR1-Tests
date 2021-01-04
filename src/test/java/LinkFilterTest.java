import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkFilterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void out() {
        LinkFilter.main("test.html");
        assertTrue(outContent.toString().contains("http://www.google.com"));
        assertTrue(outContent.toString().contains("Heise Online"));
        assertTrue(outContent.toString().contains("http://www.heise.de"));
        assertTrue(outContent.toString().contains("Hochschule für Technik und Wirtschaft"));
        assertTrue(outContent.toString().contains("http://www.htwsaar.de/"));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

}