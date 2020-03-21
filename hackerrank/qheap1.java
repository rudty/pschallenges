import java.io.*;
import java.util.*;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int cmdCount = scanner.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < cmdCount; ++i) {
            int cmd = scanner.nextInt();
            if (cmd == 1) {
                int value = scanner.nextInt();
                q.add(value);
            }
            if (cmd == 2) {
                int value = scanner.nextInt();
                q.remove(value);
            }
            if (cmd == 3) {
                System.out.println(q.peek());
            }
        }
    }
}