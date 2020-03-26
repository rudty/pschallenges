    static String[] weightedUniformStrings(String s, int[] queries) {
        TreeSet<Integer> m = new TreeSet<>();
        int beforeKeyCode = 0;
        int sameCount = 1;
        for (int i = 0; i < s.length(); ++i) {
            int keyCode = s.charAt(i) - 'a' + 1;
            if (keyCode == beforeKeyCode) {
                sameCount += 1;
            } else {
                sameCount = 1;
            }
            beforeKeyCode = keyCode;
            m.add(keyCode * sameCount);
        }
        return Arrays.stream(queries)
                .mapToObj(e -> m.contains(e) ? "Yes" : "No")
                .parallel() // :)
                .collect(java.util.stream.Collectors.toList())
                .toArray(new String[queries.length]);
    }