package map;

import java.util.SortedMap;
import java.util.TreeMap;

public class AddToMap {
    public static void main(String[] args) {

        SortedMap<String, Integer> sortedMap = new TreeMap<>();
        sortedMap.put("Alpha", 1);
        sortedMap.put("Omega", 24);
        sortedMap.put("Gamma", 3);
        System.out.println(sortedMap);
    }
}
