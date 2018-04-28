package list;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ConvertToObjectArrayTest {

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
    }

    @Test
    public void main() {
        ConvertToObjectArray.main();
        StringBuilder sb = new StringBuilder(
                "{letter='Gamma', position=3}" + System.lineSeparator() +
                        "{letter='Omega', position=24}" + System.lineSeparator() +
                        "{letter='Alpha', position=1}" + System.lineSeparator()
        );
        assertEquals(sb.toString(), outContent.toString());
    }

    @Test
    public void toArray() {
        List<ConvertToObjectArray.GreekLetter> letterList = new ArrayList<>();
        letterList.add(new ConvertToObjectArray.GreekLetter("Gamma", 3));
        ConvertToObjectArray.GreekLetter[] c = new ConvertToObjectArray.GreekLetter[]{
                new ConvertToObjectArray.GreekLetter("Gamma", 3)};
        assert Arrays.equals(c, ConvertToObjectArray.toArray(letterList));
    }
}

