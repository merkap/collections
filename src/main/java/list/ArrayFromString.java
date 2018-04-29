package list;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayFromString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String st = scanner.nextLine();
        List<String> list = Arrays.asList(st.split(" "));
        System.out.println(list);
    }
}