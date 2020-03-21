import java.io.*;
import java.util.*;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int cmdCount = scanner.nextInt();
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        for (int i = 0; i < cmdCount; ++i) {
            int cmd = scanner.nextInt();
            if (cmd == 1) {
                int value = scanner.nextInt();
                stack1.add(value);
            }
            if (cmd == 2) {
                if (!stack2.isEmpty()) {
                    stack2.pollFirst();
                } else {
                    while (!stack1.isEmpty()) {
                        stack2.add(stack1.pollFirst());
                    }
                    stack2.pollFirst();
                }
            }
            if (cmd == 3) {
                if (!stack2.isEmpty()) {
                    System.out.println(stack2.peekFirst());
                } else {
                    while (!stack1.isEmpty()) {
                        stack2.add(stack1.pollFirst());
                    }
                    System.out.println(stack2.peekFirst());
                }
            }
        }
    }
}