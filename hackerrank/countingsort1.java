    static int[] countingSort(int[] arr) {
        int[] result = new int[100];
        for (int i = 0; i < arr.length; ++i) {
            result[arr[i]] += 1;
        }
        return result;
    }