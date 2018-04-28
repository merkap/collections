package list;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class AddToArrayListTest {

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
    public void elements() {
        assert AddToArrayList.list.contains(2);
        assert AddToArrayList.list.contains(0);
        assert AddToArrayList.list.contains(7);
        assert AddToArrayList.list.contains(1);
    }

    @Test
    public void main() {
        AddToArrayList.main();
        assertEquals("[2, 0, 1, 7]" + System.lineSeparator(), outContent.toString());
    }
}