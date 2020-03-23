    static int[] cutTheSticks(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        int minValue = Arrays.stream(arr).min().getAsInt();
        while (minValue != 0) {
            int runCount = 0;
            for (int i = 0; i < arr.length; ++i) {
                if (arr[i] != 0) {
                    arr[i] -= minValue;
                    runCount += 1;
                }
            }
            result.add(runCount);
            minValue = Arrays.stream(arr).filter(e -> e > 0).min().orElse(0);
        }

        return result.stream().mapToInt(e -> e).toArray();
    }
