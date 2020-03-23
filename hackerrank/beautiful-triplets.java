    static int beautifulTriplets(int d, int[] arr) {
        int c = 0;
        for (int i = 0; i < arr.length; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                if (Math.abs(arr[i] - arr[j]) == d) {
                    for (int k = j + 1; k < arr.length; ++k) {
                        if (Math.abs(arr[j] - arr[k]) == d) {
                            c += 1;
                        }
                    }
                }
            }
        }
        return c;
    }
