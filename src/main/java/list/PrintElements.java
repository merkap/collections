package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintElements {

    public static void main(String[] args) {

        List<String> nameList = new ArrayList<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));

        for (String n : nameList) {
            System.out.println(n);
        }
    }
}