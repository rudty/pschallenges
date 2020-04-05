import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int cmdCount = scan.nextInt();

        length = 1001; // testCaseBug?
        int[][] bit = new int[2][length];
        for (int cmd_i = 0; cmd_i < cmdCount; ++cmd_i) {
            scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            String cmd = scan.next();
            int what = scan.nextInt() - 1;
            int value = scan.nextInt();

            if ("AND".equals(cmd)) {
                for (int i = 0; i < length; ++i) {
                    if (bit[0][i] + bit[1][i] != 2) {
                        bit[what][i] = 0;
                    }
                }
            } else if ("SET".equals(cmd)) {
                bit[what][value] = 1;
            } else if ("FLIP".equals(cmd)) {
                if (bit[what][value] == 1) {
                    bit[what][value] = 0;
                } else {
                    bit[what][value] = 1;
                }
            } else if ("OR".equals(cmd)) {
                for (int i = 0; i < length; ++i) {
                    if (bit[0][i] + bit[1][i] != 0) {
                        bit[what][i] = 1;
                    }
                }
            } else if ("XOR".equals(cmd)) {
                for (int i = 0; i < length; ++i) {
                    if (bit[0][i] + bit[1][i] == 1) {
                        bit[what][i] = 1;
                    } else {
                        bit[what][i] = 0;
                    }
                }
            }

//            System.out.println(cmd_i + " " + Arrays.toString(bit[0]) + " " + Arrays.toString(bit[1]));
            System.out.print(Arrays.stream(bit[0]).sum());
            System.out.print(" ");
            System.out.println(Arrays.stream(bit[1]).sum());
        }
    }
}