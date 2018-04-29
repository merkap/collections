package queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StackSimulatorTest {

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
                ("5\n" +
                        "push 2\n" +
                        "push 1\n" +
                        "max\n" +
                        "pop\n" +
                        "max\n").getBytes()
        ));
        StackSimulator.main();
        assertEquals("2" + System.lineSeparator() +
                "2" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void main2() {
        System.setIn(new ByteArrayInputStream(
                ("10\n" +
                        "push 2\n" +
                        "push 1\n" +
                        "push 1\n" +
                        "max\n" +
                        "pop\n" +
                        "pop\n" +
                        "push 1\n" +
                        "push 5\n" +
                        "push 1\n" +
                        "max\n").getBytes()
        ));
        StackSimulator.main();
        assertEquals("2" + System.lineSeparator() +
                "5" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void wrong() {
        System.setIn(new ByteArrayInputStream(
                ("5\n" +
                        "push 2\n" +
                        "push 1\n" +
                        "max\n" +
                        "pop\n" +
                        "max\n").getBytes()
        ));

        StackSimulator.main();
        assertNotEquals(" ", outContent.toString());
    }
}