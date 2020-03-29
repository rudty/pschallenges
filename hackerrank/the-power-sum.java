 static TreeMap<String, Integer> cache = new TreeMap<>();
    static int findPowSum(ArrayList<Integer> arr, int X, int N, int index) {
        //https://www.youtube.com/watch?v=tGKS6R7QS1A
        if (X == 0) {
            return 1;
        }
        if (index >= arr.size()) {
            return 0;
        }
        String cacheKey = X + "-" + index;
        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }
        int removeValue = (int)Math.pow(arr.get(index), N);
        int ways = 0;
        ways += findPowSum(arr, X, N, index + 1); // without using arr[index];
        ways += findPowSum(arr, X - removeValue, N, index + 1); // with using arr[index];
        cache.put(cacheKey, ways);
        return ways;
    }
    // Complete the powerSum function below.
    static int powerSum(int X, int N) {
        ArrayList<Integer> arr = new ArrayList<>();
        int sqrtX = (int)Math.sqrt(X);
        for (int i = 1; i <= sqrtX; ++i) {
            arr.add(i);
        }
        return findPowSum(arr, X, N, 0);
    }
