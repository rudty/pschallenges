    static int makingAnagrams(String s1, String s2) {
 
        Map<Integer, Long> m1 = s1.chars()
                .boxed()
                .collect(
                        java.util.stream.Collectors.groupingBy(
                                java.util.function.Function.identity(),
                                java.util.stream.Collectors.counting()));

        Map<Integer, Long> m2 = s2.chars()
                .boxed()
                .collect(
                        java.util.stream.Collectors.groupingBy(
                                java.util.function.Function.identity(),
                                java.util.stream.Collectors.counting()));

        int count = 0;
        for (Map.Entry<Integer, Long> entry : m1.entrySet()) {
            count += Math.max(0, entry.getValue() - m2.getOrDefault(entry.getKey(), 0L));
        }

        for (Map.Entry<Integer, Long> entry : m2.entrySet()) {
            count += Math.max(0, entry.getValue() - m1.getOrDefault(entry.getKey(), 0L));
        }

        return count;
    }