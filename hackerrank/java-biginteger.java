import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        java.math.BigInteger a = new java.math.BigInteger(scan.nextLine());
        java.math.BigInteger b = new java.math.BigInteger(scan.nextLine());
        System.out.println(a.add(b));
        System.out.println(a.multiply(b));
    }
}