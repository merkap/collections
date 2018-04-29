package set;

import java.util.SortedSet;

public class TreeSet {
    public static void main(String[] args) {
        SortedSet<String> set = new java.util.TreeSet<>();
        set.add("Gamma");
        set.add("Alpha");
        set.add("Omega");
        System.out.println(set);
    }
}

