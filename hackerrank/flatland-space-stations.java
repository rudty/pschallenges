    static int flatlandSpaceStations(int n, int[] c) {
        Arrays.sort(c);
        int distance = c[0];
        for (int i = 1; i < c.length; ++i) {
            distance = Math.max(distance, (c[i] - c[i - 1]) / 2);
        }
        distance = Math.max(n - 1 - c[c.length - 1], distance);
        return distance;
    }
