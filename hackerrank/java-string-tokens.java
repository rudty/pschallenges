import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] r = Arrays.stream(s.split("[^A-Za-z]"))
                .filter(e -> e.length() > 0)
                .toArray(String[]::new);
        System.out.println(r.length);
        Arrays.stream(r).forEach(System.out::println);
    }
}

