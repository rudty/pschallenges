    static int[] icecreamParlor(int m, int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[i] + arr[j] == m) {
                    return new int[] { i + 1, j + 1 };
                }
            }
        }
        return new int[] { 0, 0 };
    }
