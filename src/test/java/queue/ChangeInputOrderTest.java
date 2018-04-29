package queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ChangeInputOrderTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
        System.setIn(System.in);
    }

    @Test
    public void main() {
        System.setIn(new ByteArrayInputStream(
                ("4\n" +
                        "1\n" +
                        "2\n" +
                        "3\n" +
                        "4\n").getBytes()
        ));

        ChangeInputOrder.main();
        assertEquals(
                "4" + System.lineSeparator() +
                        "2" + System.lineSeparator() +
                        "1" + System.lineSeparator() +
                        "3" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void wrong() {
        System.setIn(new ByteArrayInputStream(
                ("4\n" +
                        "1\n" +
                        "2\n" +
                        "3\n" +
                        "4\n").getBytes()
        ));

        ChangeInputOrder.main();
        assertNotEquals("4" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "2" + System.lineSeparator(), outContent.toString());
    }
}