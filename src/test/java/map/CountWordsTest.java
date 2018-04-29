package map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CountWordsTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        System.setIn(new ByteArrayInputStream(
                ("a aa abC aa ac abc bcd a\n").getBytes()
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
        CountWords.main();
        assertEquals(
                "a 2" + System.lineSeparator() +
                        "aa 2" + System.lineSeparator() +
                        "abc 2" + System.lineSeparator() +
                        "ac 1" + System.lineSeparator() +
                        "bcd 1" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void wrong() {
        CountWords.main();
        assertNotEquals(" ", outContent.toString());
    }
}