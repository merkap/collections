package set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LexicographicOrderInputTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        System.setIn(new ByteArrayInputStream(
                ("6\n" +
                        "postgres\n" +
                        "sqlite\n" +
                        "oracle\n" +
                        "mongodb\n" +
                        "postgres\n" +
                        "mssql\n").getBytes()
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
        LexicographicOrderInput.main();
        assertEquals(
                "mongodb" + System.lineSeparator() +
                        "mssql" + System.lineSeparator() +
                        "oracle" + System.lineSeparator() +
                        "postgres" + System.lineSeparator() +
                        "sqlite" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void wrong() {
        LexicographicOrderInput.main();
        assertNotEquals(" ", outContent.toString());
    }
}