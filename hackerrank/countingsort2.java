    static int[] countingSort(int[] arr) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int i = 0; i < arr.length; ++i) {
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        }

        int[] result = new int[arr.length];
        int it = 0;
        while (!m.isEmpty()) {
            Map.Entry<Integer, Integer> e = m.pollFirstEntry();
            for (int i = 0; i < e.getValue(); ++i) {
                result[it++] = e.getKey();
            }
        }
        return result;
    }