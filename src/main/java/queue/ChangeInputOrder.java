package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ChangeInputOrder {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        Deque<Integer> deque = new ArrayDeque<>(i);
        for (int j = 1; j <= i; j++)
            if (j % 2 == 0) deque.offerFirst(scanner.nextInt());
            else deque.offerLast(scanner.nextInt());
        for (int j = 0; j < i; j++) System.out.println(deque.pollFirst());
    }
}
