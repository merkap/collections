package map;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SpellChecker {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> knownWords = new HashSet<>();
        Set<String> unknownWords = new HashSet<>();
        int i = scanner.nextInt();
        scanner.nextLine();
        for (int j = 0; j < i; j++) {
            knownWords.add(scanner.nextLine().trim().toLowerCase());
        }
        i = scanner.nextInt();
        scanner.nextLine();
        for (int j = 0; j < i; j++) {
            for (String w : scanner.nextLine().split(" ")) {
                w = w.toLowerCase();
                if (!knownWords.contains(w)) unknownWords.add(w);
            }
        }
        for (String s :
                unknownWords) {
            System.out.println(s);
        }
    }
}
