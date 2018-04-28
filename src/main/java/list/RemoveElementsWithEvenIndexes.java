package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RemoveElementsWithEvenIndexes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        while (scanner.hasNextInt()) {
            if (i % 2 != 0) {
                list.add(scanner.nextInt());
            } else {
                scanner.nextInt();
            }
            i++;
        }
        Collections.reverse(list);
        for (Integer r :
                list) {
            System.out.printf("%d ", r);
        }
    }
}