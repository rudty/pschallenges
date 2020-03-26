    static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        int minValue = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; ++i) {
            minValue = Math.min(minValue, Math.abs(arr[i] - arr[i - 1]));
            minValue = Math.min(minValue, Math.abs(arr[i - 1] - arr[i]));
        }

        return minValue;
    }
