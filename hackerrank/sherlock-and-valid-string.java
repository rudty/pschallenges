    static String isValid(String s) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            int index = s.charAt(i) - 'a';
            alphabet[index] += 1;
        }

        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int i = 0; i < alphabet.length; ++i) {
            if (alphabet[i] > 0) {
                m.put(alphabet[i], m.getOrDefault(alphabet[i], 0) + 1);
            }
        }

        if (m.size() >= 3) {
            return "NO";
        }
        if (m.size() == 1) {
            return "YES";
        }
        Map.Entry<Integer, Integer> e1 = m.pollFirstEntry();
        Map.Entry<Integer, Integer> e2 = m.pollFirstEntry();
        if (e1.getKey() == 1 && e1.getValue() == 1) {
            return "YES";
        }
        if (e2.getKey() == 1 && e2.getValue() == 1) {
            return "YES";
        }
        if (Math.abs(e1.getKey() - e2.getKey()) != 1) {
            return "NO";
        }
        if (e1.getValue() > 1 && e2.getValue() > 1) {
            return "NO";
        }
        return "YES";
    }