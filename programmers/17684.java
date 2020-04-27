import java.util.HashMap;
import java.util.LinkedList;
class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> dictionary = new HashMap<>();
        int index = 1;
        for (int i = 0; i < 26; ++i) {
            dictionary.put(String.valueOf((char)(i + 'A')), index++);
        }
        LinkedList<Integer> out = new LinkedList<>();
        String acc = "";
        for (int i = 0; i < msg.length(); ++i) {
            char e = msg.charAt(i);
            String next = acc + e;
            if (dictionary.containsKey(next)) {
                acc = next;
            } else {
//                System.out.println(acc +" " +dictionary.get(acc));
                out.add(dictionary.get(acc));
                dictionary.put(next, index++);
                acc = String.valueOf(e);
            }
        }
        if (acc.length() > 0) {
            out.add(dictionary.get(acc));
//            System.out.println(acc +" " +dictionary.get(acc));
        }
//        System.out.println(dictionary);
        return out.stream().mapToInt(e -> e).toArray();
    }
}