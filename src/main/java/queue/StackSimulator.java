package queue;

import java.util.Scanner;
import java.util.Stack;

public class StackSimulator {
    public static void main(String... args) {


        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackMax = new Stack<>();
        String string;
        int i = Integer.parseInt(scanner.nextLine());

        Integer member;

        for (int j = 0; j < i; j++) {
            string = scanner.nextLine();

            if (string.startsWith("pu")) {
                member = Integer.parseInt(string.substring(5), 10);
                if (stack.size() == 0) {
                    stackMax.push(member);
                    stack.push(member);
                } else {
                    if (member >= stackMax.peek()) {
                        stackMax.push(member);
                    }
                    stack.push(member);
                }
            } else if (string.startsWith("po")) {
                if (stack.peek().equals(stackMax.peek()))
                    stackMax.pop();
                stack.pop();
            } else {
                System.out.println(stackMax.peek());
            }
        }
    }


//        Scanner scanner = new Scanner(System.in);
//        Deque<Integer> deque = new ArrayDeque<>();
//        Deque<Integer> deque1;
//        String string;
//        int i = Integer.parseInt(scanner.nextLine());
//
//        Integer member = Integer.parseInt(scanner.nextLine().substring(5), 10);
////        Integer member = Integer.parseInt(string.trim().split(" ")[1]);
//        deque.add(member);
//        Integer max = member;
//        boolean hasMax = true;
//
//        for (int j = 1; j < i; j++) {
//            string = scanner.nextLine();
//
//            if (string.startsWith("pu")) {
//                member = Integer.parseInt(string.substring(5), 10);
////                member = Integer.parseInt(string.trim().split(" ")[1]);
//                deque.add(member);
//                if (member > max) {
//                    max = member;
//                    hasMax = true;
//                }
//            } else if (string.startsWith("po")) {
//                deque.removeLast();
//                hasMax = false;
//            } else {
//                if (!hasMax) {
//                    max = 0;
//                    deque1 = ((ArrayDeque<Integer>) deque).clone();
//                    while (!deque1.isEmpty()) {
//                        member = deque1.remove();
//                        if (member > max) max = member;
//                    }
//                }
//                hasMax = true;
//                System.out.println(max);
//            }
//        }
//    }


}