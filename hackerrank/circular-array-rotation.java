    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int[] b = new int[a.length];;
        int it = 0;
        k %= a.length;
        for (int i = k; i < a.length; ++i) {
            b[i] = a[it++];
        }
        for (int i = 0; i < k; ++i) {
            b[i] = a[it++];
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            result[i] = b[queries[i]];
        }
        return result;
    }