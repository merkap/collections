package queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class AddToArrayDeque {

    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(2);
        queue.add(0);
        queue.offer(1);
        queue.offer(7);

        System.out.println(queue);

    }
}