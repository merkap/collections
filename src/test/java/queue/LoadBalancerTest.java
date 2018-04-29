package queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LoadBalancerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        System.setIn(new ByteArrayInputStream(
                "6\n1 1\n2 1\n3 1\n4 3\n5 1\n6 1".getBytes()
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
        LoadBalancer.main();
        assertEquals("1 3 5 6 " + System.lineSeparator() +
                "2 4 " + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void wrong() {
        ReverseInputOrder.main();
        assertNotEquals("1" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "3" + System.lineSeparator(), outContent.toString());
    }
}