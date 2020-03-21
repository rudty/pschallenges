import java.util.*;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int cmdCount = scanner.nextInt();
        LinkedList<Integer> stack = new LinkedList<>();
        TreeMap<Integer, Integer> numberMap = new TreeMap<>();
        for (int i = 0; i < cmdCount; ++i) {
            int cmd = scanner.nextInt();
            if (cmd == 1) {
                int value = scanner.nextInt();
                stack.add(value);
                numberMap.put(value, numberMap.getOrDefault(value, 0) + 1);
            }
            if (cmd == 2) {
                int value = stack.removeLast();
                int count = numberMap.getOrDefault(value, 0) - 1;
                if (count <= 0) {
                    numberMap.remove(value);
                } else {
                    numberMap.put(value, count);
                }
            }
            if (cmd == 3) {
                java.util.Map.Entry<Integer, Integer> entry = numberMap.lastEntry();
                System.out.println(entry.getKey());
            }
        }
    }
}