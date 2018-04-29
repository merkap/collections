package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SwapElements {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        for (String s : scanner.nextLine().trim().split(" ")) {
            list.add(Integer.parseInt(s));
        }
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            Collections.swap(list, scanner.nextInt(), scanner.nextInt());
        }
        for (Integer i :
                list) {
            System.out.printf("%d ", i);
        }
    }
}
