    static int equalizeArray(int[] arr) {
        int[] numbers = new int[101];

        int maxCount = 0;
        for (int e : arr) {
            numbers[e] += 1;
            maxCount = Math.max(numbers[e], maxCount);
        }

        return arr.length - maxCount;
    }
