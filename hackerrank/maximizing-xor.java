    static int maximizingXor(int l, int r) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = l; i <= r; ++i) {
            for (int j = l; j <= r; ++j) {
                maxValue = Math.max((i ^ j), maxValue);
            }
        }
        return maxValue;
    }