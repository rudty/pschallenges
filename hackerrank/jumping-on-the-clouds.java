    static int MAX_VALUE = 200;
    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int[][] step = new int[c.length][2];

        if (c[1] == 1) {
            step[1][0] = MAX_VALUE; // 0 = before
        } else {
            step[1][0] = 1;
        }
        step[1][1] = MAX_VALUE; // 1 = before before

        for (int i = 2; i < c.length; ++i) {
            if (c[i] == 1) {
                step[i][0] = MAX_VALUE;
                step[i][1] = MAX_VALUE;
            } else {
                step[i][0] = Math.min(step[i - 1][0], step[i - 1][1]) + 1;
                step[i][1] = Math.min(step[i - 2][0], step[i - 2][1]) + 1;
            }
        }


        return Math.min(step[c.length - 1][0], step[c.length - 1][1]);
    }