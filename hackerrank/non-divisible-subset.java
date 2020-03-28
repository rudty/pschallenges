    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        int[] counting = new int[k + 1];
        for (int e : s) {
            counting[e % k] += 1;
        }

        int result = 0;
        int half = counting.length / 2;
        for (int i = 1; i < half; ++i) {
            result += Math.max(counting[i], counting[counting.length - i - 1]);
        }

        if (counting[0] > 0) {
            result += 1;
        }
        if (k % 2 == 0 && counting[k/2] > 0) {
            result += 1;
        }
//        System.out.println(Arrays.toString(counting));

        return result;
    }