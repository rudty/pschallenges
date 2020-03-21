    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        /*
         * Write your code here.
         */
        int h1Sum = Arrays.stream(h1).sum();
        int h2Sum = Arrays.stream(h2).sum();
        int h3Sum = Arrays.stream(h3).sum();
        int i = 0;
        int j = 0;
        int k = 0;
        while (true) {
            if (h1Sum == h2Sum && h3Sum == h2Sum) {
                return h1Sum;
            }
            if (h1Sum >= h2Sum && h1Sum >= h3Sum) {
                h1Sum -= h1[i];
                i += 1;
            } else if (h2Sum >= h1Sum && h2Sum >= h3Sum) {
                h2Sum -= h2[j];
                j += 1;
            } else if (h3Sum >= h1Sum && h3Sum >= h2Sum) {
                h3Sum -= h3[k];
                k += 1;
            }
        }
    }