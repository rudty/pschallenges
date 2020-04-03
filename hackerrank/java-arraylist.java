import java.io.*;
import java.util.*;

public class Solution {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int arrayCount = scan.nextInt();

        int[][] a = new int[arrayCount][];
        for (int i = 0; i < arrayCount; ++i) {
            scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            a[i] = Arrays.stream(scan.nextLine().split(" "))
                    .skip(1)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int queryCount = scan.nextInt();
        for (int i = 0; i < queryCount; ++i) {
            int y = scan.nextInt();
            int x = scan.nextInt();
            y -= 1;
            x -= 1;
            if (0 <= y && y < arrayCount && 0 <= x && x < (a[y].length)) {
                System.out.println(a[y][x]);
            } else {
                System.out.println("ERROR!");
            }
        }

    }
}