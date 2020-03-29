    static int doAccumulation(long sum) {
        while (sum / 10 > 0) {
            long num = sum;
            long acc = 0;
            while (num > 0) {
                acc += num % 10;
                num /= 10;
            }
            sum = acc;
        }
        return (int)sum;
    }

    // Complete the superDigit function below.
    static int superDigit(String n, int k) {
        long num = 0;
        for (int i = 0; i < k % 9; ++i) {
            for (int j = 0; j < n.length(); ++j) {
                num += n.charAt(j) - '0';
            }
        }
        return doAccumulation(num);
    }
