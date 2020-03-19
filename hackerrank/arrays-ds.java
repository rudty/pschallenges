    static int[] reverseArray(int[] a) {
        int half = a.length / 2;
        for (int i = 0; i < half; ++i) {
            int destIndex = a.length - i - 1;
            int temp = a[i];
            a[i] = a[destIndex];
            a[destIndex] = temp;
        }
        return a;
    }