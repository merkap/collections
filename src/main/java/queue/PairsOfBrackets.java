package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PairsOfBrackets {
    public static void main(String... args) {

        Deque<Character> stack = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        for (char ch : s.trim().toCharArray()) {
            switch (ch) {
                case '{':
                case '(':
                case '[':
                    stack.push(ch);
                    break;
                case '}':
                    if (!(!stack.isEmpty() && stack.pop() == '{')) {
                        System.out.println(false);
                        return;
                    }
                    break;
                case ']':
                    if (!(!stack.isEmpty() && stack.pop() == '[')) {
                        System.out.println(false);
                        return;
                    }
                    break;
                case ')':
                    if (!(!stack.isEmpty() && stack.pop() == '(')) {
                        System.out.println(false);
                        return;
                    }
                    break;
            }
        }
        if (!stack.isEmpty()) System.out.println(false);
        else System.out.println(true);
    }
}
