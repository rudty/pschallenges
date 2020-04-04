//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh)
    {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        TreeMap<String, Integer> m = new TreeMap<>();
        for(int i=0;i<n;i++)
        {
            String name=in.nextLine();
            int phone=in.nextInt();
            in.nextLine();

            m.put(name, phone);
        }
        while(in.hasNext())
        {
            String s=in.nextLine();
            Integer v = m.get(s);
            if (v != null) {
                System.out.println(s + "=" + v);
            } else {
                System.out.println("Not found");
            }
        }
    }
}



