import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    // must use BufferedReader
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] unsorted = new String[n];

        for (int i = 0; i < n; i++) {
            String unsortedItem = br.readLine();
            unsorted[i] = unsortedItem;
        }

        Arrays.sort(unsorted, new Comparator<String>() {
            @Override
            public int compare(String l, String r) {
                if (l.length() != r.length()) {
                    return l.length() - r.length();
                }

                for (int i = 0; i < l.length(); ++i) {
                    char c1 = l.charAt(i);
                    char c2 = r.charAt(i);
                    if (c1 != c2) {
                        return c1 - c2;
                    }
                }
                return 0;
            }
        });

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < unsorted.length; i++) {
            builder.append(unsorted[i]);
            builder.append("\n");
        }

        System.out.println(builder);

    }
}
