package map;

import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class PairsInRange {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int from = scanner.nextInt();
        int to = scanner.nextInt();
        int count = scanner.nextInt();
        scanner.nextLine();
        SortedMap<Integer, String> sortedMap = new TreeMap<>();
        for (int i = 0; i < count; i++) {
            sortedMap.put(scanner.nextInt(), scanner.nextLine().trim());
        }
        sortedMap = sortedMap.subMap(from, to + 1);
        for (Map.Entry<Integer, String> e :
                sortedMap.entrySet()) {
            System.out.printf("%d %s%s", e.getKey(), e.getValue(), System.lineSeparator());
        }
    }
}
