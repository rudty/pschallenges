import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        scan.nextInt();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        List<Integer> arr = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int cmdCount = scan.nextInt();

        for (int i = 0; i < cmdCount; ++i) {
            scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            String cmd = scan.next();
            scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int pos = scan.nextInt();

            if ("Insert".equals(cmd)) {
                int value = scan.nextInt();
                arr.add(pos, value);
            } else if ("Delete".equals(cmd)) {
                arr.remove(pos);
            }
        }
        arr.stream().forEach(e -> System.out.print(e +" "));

    }
}