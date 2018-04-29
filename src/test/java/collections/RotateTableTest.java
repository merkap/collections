package collections;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RotateTableTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        System.setIn(new ByteArrayInputStream(
                ("3 3\n" +
                        "1 1 1\n" +
                        "2 2 2\n" +
                        "3 3 3\n" +
                        "1\n").getBytes()
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
        RotateTable.main();
        assertEquals(
                "3 3 3" + System.lineSeparator() +
                        "1 1 1" + System.lineSeparator() +
                        "2 2 2" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void wrong() {
        RotateTable.main();
        assertNotEquals(" ", outContent.toString());
    }
}