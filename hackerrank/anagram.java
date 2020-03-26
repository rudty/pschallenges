    static int anagram(String s) {
        if (s.length() % 2 == 1) {
            return -1;
        }

        int half = s.length() / 2;
        String s1 = s.substring(0, half);
        String s2 = s.substring(half);

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        TreeMap<Character, Integer> m1 = new TreeMap<>();
        TreeMap<Character, Integer> m2 = new TreeMap<>();

        for (char c : c1) {
            m1.put(c, m1.getOrDefault(c, 0) + 1);
        }

        for (char c : c2) {
            m2.put(c, m2.getOrDefault(c, 0) + 1);
        }

        int diff = 0;
        for (Map.Entry<Character, Integer> entry : m2.entrySet()) {
            diff += Math.max(entry.getValue() - m1.getOrDefault(entry.getKey(), 0), 0);
        }

        return diff;
    }
