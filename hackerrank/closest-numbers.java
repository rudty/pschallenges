    static int[] closestNumbers(int[] arr) {
        Arrays.sort(arr);
        LinkedList<Integer> result = new LinkedList<>();
        int minValue = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; ++i) {
            int m = Math.abs(arr[i] - arr[i - 1]);
            if (m < minValue) {
                result.clear();
                minValue = m;
                result.add(arr[i - 1]);
                result.add(arr[i]);
            } else if (m == minValue) {
                result.add(arr[i - 1]);
                result.add(arr[i]);
            }
        }

        return result.stream().mapToInt(e -> e).toArray();
    }