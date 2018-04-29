package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class LoadBalancer {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        int deqLoad1 = 0;
        int deqLoad2 = 0;
        int procNum;
        int procLoad;
        while (i > 0) {
            procNum = scanner.nextInt();
            procLoad = scanner.nextInt();
            if (deqLoad1 <= deqLoad2) {
                deqLoad1 += procLoad;
                deque1.push(procNum);
            } else {
                deqLoad2 += procLoad;
                deque2.push(procNum);
            }
            i--;
        }
        while (!deque1.isEmpty()) {
            System.out.printf("%d ", deque1.pollLast());
        }
        System.out.println();
        while (!deque2.isEmpty()) {
            System.out.printf("%d ", deque2.pollLast());
        }
        System.out.println();
    }
}
