import java.util.*;
import java.text.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        // Write your code here.
        NumberFormat formatter= NumberFormat.getCurrencyInstance(new Locale("us"));
        String us = "$"+formatter.format(payment).substring(2);

        NumberFormat formatterIn = NumberFormat.getCurrencyInstance(new Locale("en"));
        String india = "Rs."+formatterIn.format(payment).substring(1);

        String china = "￥"+formatter.format(payment).substring(2);

        NumberFormat formatterFr = NumberFormat.getCurrencyInstance(new Locale("fr"));
        String france = formatterFr.format(payment);
        france = france.substring(0, france.length() - 1) + "€";
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}