import java.io.*;
import java.util.*;

public class Solution {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        scan.nextInt();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] arr = Arrays.stream(
                scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int count = 0;
        for (int i = 0; i < arr.length; ++i) {
            for (int j = i; j < arr.length; ++j) {
                int sum = 0;
                for (int k = i; k <= j; ++k) {
                    sum += arr[k];
                }
                if (sum < 0) {
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
}