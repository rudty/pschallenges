    static int pairs(int k, int[] arr) {
        TreeSet<Integer> s = new TreeSet<>();
        for (int i = 0; i < arr.length; ++i) {
            s.add(arr[i]);
        }

        int count = 0;
        for (int e : s) {
            if (s.contains(e - k)) {
                count += 1;
            }
        }

        return count;
    }
