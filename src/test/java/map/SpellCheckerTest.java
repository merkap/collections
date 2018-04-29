package map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SpellCheckerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        System.setIn(new ByteArrayInputStream(
                ("3\n" +
                        "a\n" +
                        "bb\n" +
                        "cCc\n" +
                        "2\n" +
                        "a bb aab aba ccc\n" +
                        "c bb aaa\n").getBytes()
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
        SpellChecker.main();
        Set<String> set = new HashSet<>(Arrays.asList("aaa", "aba", "aab", "c"));
        assertEquals(set,
                new HashSet<>(Arrays.asList(outContent.toString().split(System.lineSeparator()))));
    }

    @Test
    public void main2() {
        SpellChecker.main();
        assertEquals(
                "aaa" + System.lineSeparator() +
                        "aba" + System.lineSeparator() +
                        "aab" + System.lineSeparator() +
                        "c" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void wrong() {
        SpellChecker.main();
        assertNotEquals(" ", outContent.toString());
    }
}