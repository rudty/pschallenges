import java.util.*;

class KeyPair {
    char a;
    char b;

    public KeyPair(char a, char b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int hashCode() {
        return a * 1000 + b;
    }

    @Override
    public String toString() {
        return "KeyPair{" + a +" "+ b +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyPair keyPair = (KeyPair) o;
        return a == keyPair.a &&
                b == keyPair.b;
    }
}
class Solution {
    boolean isAlphabet(int c) {
        return 65 <= c && c <= 90;
    }
    ArrayList<KeyPair> toStringArray(String s) {
        ArrayList<KeyPair> r = new ArrayList<>();
        for (int i = 1; i < s.length(); ++i) {
            char a = (char)s.charAt(i - 1);
            char b = (char)s.charAt(i);
            if (!isAlphabet(a) || !isAlphabet(b)) {
                continue;
            }
            r.add(new KeyPair(a, b));
        }
        return r;
    }
    public int solution(String str1, String str2) {
        ArrayList<KeyPair> a1 = toStringArray(str1.toUpperCase());
        ArrayList<KeyPair> a2 = toStringArray(str2.toUpperCase());

        HashMap<KeyPair, Integer> s1 = new HashMap<>();
        HashMap<KeyPair, Integer> s2 = new HashMap<>();
        for (KeyPair e : a1) {
            s1.put(e, s1.getOrDefault(e, 0) + 1);
        }
        for (KeyPair e : a2) {
            s2.put(e, s2.getOrDefault(e, 0) + 1);
        }
        System.out.println(s1);
        System.out.println(s2);
        int n = 0;
        int m = 0;
        for (Map.Entry<KeyPair, Integer> entry : s1.entrySet()) {
            if (s2.containsKey(entry.getKey())) {
                n += Math.min(s2.get(entry.getKey()), entry.getValue());
                m += Math.max(s2.get(entry.getKey()), entry.getValue());
            } else {
                m += entry.getValue();
            }
        }
        for (Map.Entry<KeyPair, Integer> entry : s2.entrySet()) {
            if (!s1.containsKey(entry.getKey())) {
                m += entry.getValue();
            }
        }

        if (m == 0) {
            return 65536;
        }
        return (n * 65536) / m;
    }
}