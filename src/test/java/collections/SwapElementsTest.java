package collections;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SwapElementsTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        System.setIn(new ByteArrayInputStream(
                ("1 2 3 4 5 6\n" +
                        "2\n" +
                        "0 1\n" +
                        "3 4\n").getBytes()
        ));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
        System.setIn(System.in);
    }

    @Test
    public void main() {
        SwapElements.main();
        assertEquals(
                "2 1 3 5 4 6 ", outContent.toString());
    }

    @Test
    public void wrong() {
        SwapElements.main();
        assertNotEquals(" ", outContent.toString());
    }
}