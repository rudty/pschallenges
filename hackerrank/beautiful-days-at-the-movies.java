    static int reverseNumber(int n) {
        int[] numbers = new int[8];
        int len = 0;
        for (int i = 0; n != 0; ++i, n /= 10, ++len) {
            numbers[i] = n % 10;
        }

        int r = 0;
        for (int i = 0; i < len; ++i) {
            r *= 10;
            r += numbers[i];
        }
        return r;
    }

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        int beautiful = 0;
        for (; i <= j; ++i) {
            int reverse = Math.abs(i - reverseNumber(i));
            if (reverse % k == 0) {
                beautiful += 1;
            }
        }
        return beautiful;
    }
