package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ChangeInputOrder {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        Deque<Integer> deque = new ArrayDeque<>(i);
        Integer number;
        for (int j = 1; j <= i; j++) {
            number = scanner.nextInt();
            if (number % 2 == 0) deque.addFirst(number);
            else deque.addLast(number);
        }
        for (int j = 0; j < i; j++) System.out.println(deque.removeFirst());
    }
}
