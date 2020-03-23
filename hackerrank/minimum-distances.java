    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
        TreeMap<Integer, Integer> distance = new TreeMap<>();
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; ++i) {
            Integer lastPosition = distance.get(a[i]);
            if (lastPosition != null) {
                minDistance = Math.min(minDistance, i - lastPosition);
            }
            distance.put(a[i], i);
        }

        if (minDistance == Integer.MAX_VALUE) {
            return -1;
        }
        return minDistance;
    }
