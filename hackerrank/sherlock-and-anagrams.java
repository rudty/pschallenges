    static String toSortedString(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        TreeMap<String, Integer> m = new TreeMap<>();
        for (int i = 1; i < s.length(); ++i) {
            for (int j = 0; j <= s.length() - i; ++j) {
                String r = s.substring(j, j + i);
                String sorted = toSortedString(r);
                m.put(sorted, m.getOrDefault(sorted, 0 ) + 1);
            }
        }

        int c = 0;
        for (Map.Entry<String, Integer> entry : m.entrySet()) {
//            String k = entry.getKey();
            int count = entry.getValue();

            if (count > 1) {
                // aC2 => (a * a - 1) / 2
                c += ((count * (count - 1)) / 2);
            }
        }
        return c;
    }