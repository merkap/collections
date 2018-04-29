package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ciphering {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Character> straight = new HashMap<>();
        Map<Character, Character> backwards = new HashMap<>();

        char[] line1 = scanner.nextLine().trim().toCharArray();
        char[] line2 = scanner.nextLine().trim().toCharArray();

        for (int i = 0; i < line1.length; i++) {
            straight.put(line1[i], line2[i]);
            backwards.put(line2[i], line1[i]);
        }
        line1 = scanner.nextLine().trim().toCharArray();
        line2 = scanner.nextLine().trim().toCharArray();
//        for (int i = 0; i < line1.length; i++) {
//            line1[i] = straight.get(line1[i]);
//        }
//        System.out.println(line1);
//        for (int i = 0; i < line2.length; i++) {
//            line2[i] = backwards.get(line2[i]);
//        }
//        System.out.println(line2);

        for (char aLine1 : line1) {
            System.out.print(straight.get(aLine1));
        }
        System.out.println();
        for (char aLine2 : line2) {
            System.out.print(backwards.get(aLine2));
        }
        System.out.println();

    }
}
