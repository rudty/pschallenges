import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        StringBuilder[] builders = new StringBuilder[101];
        for (int i = 0; i < builders.length; ++i) {
            builders[i] = new StringBuilder();
        }

        int half = n / 2;
        for (int i = 0; i < n; ++i) {
            String[] input = bufferedReader.readLine().split(" ");
            int where = Integer.parseInt(input[0]);
            String str;
            if (i < half) {
                str = "-";
            } else {
                str = input[1];
            }
            builders[where].append(str);
            builders[where].append(' ');
        }

        for (int i = 1; i < builders.length; ++i) {
            builders[0].append(builders[i]);
        }
        System.out.println(builders[0]);

        bufferedReader.close();
    }
}
