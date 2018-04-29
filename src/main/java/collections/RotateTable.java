package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RotateTable {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        scanner.nextLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            list.add(scanner.nextLine());
        }
        int count = scanner.nextInt();
        Collections.rotate(list, count);
        for (String s :
                list) {
            System.out.println(s);
        }
    }
}
