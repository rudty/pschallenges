  static int[] missingNumbers(int[] arr, int[] brr) {
        Map<Integer, Long> m1 = Arrays.stream(arr)
                .boxed()
                .collect(
                        java.util.stream.Collectors.groupingBy(
                                java.util.function.Function.identity(),
                                java.util.stream.Collectors.counting()));

        Map<Integer, Long> m2 = Arrays.stream(brr)
                .boxed()
                .collect(
                        java.util.stream.Collectors.groupingBy(
                                java.util.function.Function.identity(),
                                java.util.stream.Collectors.counting()));


        LinkedList<Integer> missing = new LinkedList<>();
        for (Map.Entry<Integer, Long> entry : m1.entrySet()) {
            if (entry.getValue() - m2.getOrDefault(entry.getKey(), 0L) > 0) {
                missing.add(entry.getKey());
            }
        }

        for (Map.Entry<Integer, Long> entry : m2.entrySet()) {
            if (entry.getValue() - m1.getOrDefault(entry.getKey(), 0L) > 0) {
                missing.add(entry.getKey());
            }
        }

        int[] result = missing.stream().mapToInt(e -> e).toArray();
        Arrays.sort(result);
        return result;
    }
