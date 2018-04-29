package map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CipheringTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        System.setIn(new ByteArrayInputStream(
                ("abcd\n" +
                        "*d%#\n" +
                        "abacabadaba\n" +
                        "#*%*d*%\n").getBytes()
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
        Ciphering.main();
        assertEquals(
                "*d*%*d*#*d*" + System.lineSeparator() +
                        "dacabac" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void wrong() {
        Ciphering.main();
        assertNotEquals(" ", outContent.toString());
    }
}