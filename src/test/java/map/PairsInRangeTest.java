package map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import queue.PairsOfBrackets;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PairsInRangeTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        System.setIn(new ByteArrayInputStream(
                ("2 4\n" +
                        "5\n" +
                        "1 aa\n" +
                        "5 ee\n" +
                        "2 bb\n" +
                        "4 dd\n" +
                        "3 cc\n").getBytes()
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
        PairsInRange.main();
        assertEquals(
                "2 bb" + System.lineSeparator() +
                        "3 cc" + System.lineSeparator() +
                        "4 dd" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void wrong() {
        PairsOfBrackets.main();
        assertNotEquals(" ", outContent.toString());
    }
}