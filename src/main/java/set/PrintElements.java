package set;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class PrintElements {
    public static void main(String[] args) {
        Set<String> nameSet = new TreeSet<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));
        for (String name :
                nameSet) {
            System.out.println(name);
        }

    }
}
