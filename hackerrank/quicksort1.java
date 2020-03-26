    static int[] quickSort(int[] arr) {
        int[] result = new int[arr.length];
        int it = 0;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] < arr[0]) {
                result[it++] = arr[i];
            }
        }

        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == arr[0]) {
                result[it++] = arr[i];
            }
        }

        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] > arr[0]) {
                result[it++] = arr[i];
            }
        }
        return result;
    }