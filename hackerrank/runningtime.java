    // Complete the runningTime function below.
    static int runningTime(int[] arr) {
        int shiftCount = 0;
        for (int i = 1; i < arr.length; ++i) {
            for (int j = i; j >= 1; --j) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    shiftCount += 1;
                }
            }
        }
        return shiftCount;
    }
