package queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ManipulateQueue {

    public static void main(String[] args) {

        Deque<Integer> queue = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4));

        queue.add(5);
        queue.remove();
        queue.poll();

        System.out.println(queue);

    }
}