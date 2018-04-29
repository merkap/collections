package set;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class LexicographicOrderInput {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        scanner.nextLine();
        SortedSet<String> sortedSet = new TreeSet<>();
        for (int j = 0; j < i; j++) {
            sortedSet.add(scanner.nextLine());
        }
        for (String s :
                sortedSet) {
            System.out.println(s);
        }
    }
}
