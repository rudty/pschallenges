    static int introTutorial(int V, int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == V) {
                return i;
            }
        }
        return -1;
    }