   // line:59         int[] result = serviceLane(n, width, cases);
   static int[] serviceLane(int n, int[] width, int[][] cases) {
        int[] result = new int[cases.length];
        for (int i = 0; i < cases.length; ++i) {
            int begin = cases[i][0];
            int end = cases[i][1] + 1;

            int minValue = Integer.MAX_VALUE;
            for (int j = begin; j < end; ++j) {
                minValue = Math.min(minValue, width[j]);
            }
            result[i] = minValue;
        }
        return result;
    }