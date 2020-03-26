    static String gameOfThrones(String s) {

        Map<Integer, Long> m = s.chars()
                .boxed()
                .collect(
                        java.util.stream.Collectors.groupingBy(
                                java.util.function.Function.identity(), 
                                java.util.stream.Collectors.counting()));

        int oddCount = 0;
        for (Map.Entry<Integer, Long> entry : m.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                oddCount += 1;
            }
        }

        if (s.length() % 2 == 1) {
            if (oddCount == 1) {
                return "YES";
            }
        } else {
            if (oddCount == 0) {
                return "YES";
            }
        }
        return "NO";
    }