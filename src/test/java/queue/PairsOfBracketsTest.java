package queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PairsOfBracketsTest {
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
    public void test11() {
        System.setIn(new ByteArrayInputStream(
                ("[()]{}{[()()]()}\n").getBytes()
        ));
        PairsOfBrackets.main();
        assertEquals(
                "true" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void test12() {
        System.setIn(new ByteArrayInputStream(
                ("[()]{}{()()]()}\n").getBytes()
        ));
        PairsOfBrackets.main();
        assertNotEquals(
                "true" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void test21() {
        System.setIn(new ByteArrayInputStream(
                ("()[]}\n").getBytes()
        ));
        PairsOfBrackets.main();
        assertEquals("false" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void test22() {
        System.setIn(new ByteArrayInputStream(
                ("()[]\n").getBytes()
        ));
        PairsOfBrackets.main();
        assertNotEquals("false" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void test31() {
        System.setIn(new ByteArrayInputStream(
                ("([][])\n").getBytes()
        ));
        PairsOfBrackets.main();
        assertEquals("true" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void test32() {
        System.setIn(new ByteArrayInputStream(
                ("([][)\n").getBytes()
        ));
        PairsOfBrackets.main();
        assertNotEquals("true" + System.lineSeparator(), outContent.toString());
    }
}