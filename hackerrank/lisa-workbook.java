    // Complete the workbook function below.
     static int workbook(int n, int k, int[] arr) {
        int count = 0;
        int page = 1;
        for (int i = 0; i < arr.length; ++i) {
            int problem = arr[i];
            for (int p = 1; p <= problem; ++p) {
                if ((p-1) > 0 && (p-1) % k == 0) {
                    page += 1;
                }
                if (p == page) {
                    count += 1;
                }
            }
            page += 1;
        }
        return count;
    }
