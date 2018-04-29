package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ReverseInputOrder {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        Deque queue = new ArrayDeque(i);
        for (int j = 0; j < i; j++) {
            queue.add(scanner.nextInt());
        }
        for (int j = 0; j < i; j++) {
            System.out.println(queue.pollLast());
        }
    }
}
