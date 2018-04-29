package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class StackSimulator {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int i = scanner.nextInt();
        scanner.nextLine();
        String string;
        int max = 0;
        for (int j = 0; j < i; j++) {
            string = scanner.nextLine();
            if (string.contains("max")) System.out.println(max);
            if (string.contains("pop")) deque.pop();
            if (string.contains("push")) {
                deque.push(Integer.parseInt(string.substring(5), 10));
                int size = deque.size();
                if (size > max) max = size;
            }
        }
    }
}
