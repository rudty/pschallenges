    static String balancedSums(List<Integer> arr) {
        int lhsSum = 0;
        int rhsSum = arr.stream().mapToInt(e -> e).sum();

        for (int e : arr) {
            rhsSum -= e;
            if (lhsSum == rhsSum) {
                return "YES";
            }
            lhsSum += e;
        }
        return "NO";
    }