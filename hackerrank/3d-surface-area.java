 static int surfaceArea(int[][] A) {
        int f = 0;
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < A[i].length; ++j) {
                f += 2;
                if (j > 0) {
                    f += Math.max(A[i][j] - A[i][j - 1], 0);
                }
                if (j < A[i].length - 1) {
                    f += Math.max(A[i][j] - A[i][j + 1], 0);
                }
                if (i > 0) {
                    f += Math.max(A[i][j] - A[i - 1][j], 0);
                }
                if (i < A.length - 1) {
                    f += Math.max(A[i][j] - A[i + 1][j], 0);
                }


                if (i == 0) {
                    f += A[i][j];
                }
                if (i == A.length - 1) {
                    f += A[i][j];
                }
                if (j == 0) {
                    f += A[i][j];
                }
                if (j == A[i].length - 1) {
                    f += A[i][j];
                }
            }
        }
        return f;
    }