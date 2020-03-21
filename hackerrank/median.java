import java.io.*;
import java.util.*;

public class Solution {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int cmdCount = scan.nextInt();
        ArrayList<Long> arr = new ArrayList<>(1000000);
        for (int cmd_i = 0; cmd_i < cmdCount; cmd_i++) {
            char cmd = scan.next().charAt(0);
            long value = scan.nextInt();
            int index = Collections.binarySearch(arr, value, Long::compare);
            if (cmd == 'r') {
                if (index < 0) {
                    System.out.println("Wrong!");
                    continue;
                } else {
                    arr.remove(index);
                }
            }

            if (cmd == 'a') {
                if (index < 0) {
                    index += 1;
                    index = -index;
                }
                arr.add(index, value);
            }

//            System.out.println(arr);


            if (arr.isEmpty()) {
                System.out.println("Wrong!");
            } else if (arr.size() % 2 == 1) {
                System.out.println(arr.get(arr.size() / 2));
            } else {
                long s = (long)arr.get(arr.size() / 2) + (long)arr.get(arr.size() / 2 - 1);
                if (s % 2 == 0) {
                    System.out.println(s / 2);
                } else {
                       System.out.printf("%.1f\n", s / 2.0);
                }
            }
        }
    }
}
