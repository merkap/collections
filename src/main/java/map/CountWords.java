package map;

import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class CountWords {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        SortedMap<String, Integer> sortedMap = new TreeMap<>();
        for (String word :
                array) {
            word = word.toLowerCase();
            Integer i = sortedMap.putIfAbsent(word, 1);
            if (i != null) {
                i++;
                sortedMap.put(word, i);
            }
        }
        for (Map.Entry<String, Integer> entry :
                sortedMap.entrySet()) {
            System.out.printf("%s %d", entry.getKey(), entry.getValue());
            System.out.println();
        }

    }
}
