   static String twoArrays(int k, int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; ++i) {
            if (A[i] + B[A.length - i - 1] < k) {
                return "NO";
            }
        }
        return "YES";
    }