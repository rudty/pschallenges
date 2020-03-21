    static int[] matchingStrings(String[] strings, String[] queries) {
        Map<String, Integer> m = new TreeMap<>();
        for (String s : strings) {
            m.put( s, m.getOrDefault(s, 0) + 1);
        }

        int[] queryResult = new int[queries.length];

        for (int i = 0; i < queries.length; ++i) {
            queryResult[i] = m.getOrDefault(queries[i], 0);
        }

        return queryResult;
    }
