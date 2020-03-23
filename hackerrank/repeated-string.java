    static int getACount(String s, int len) {
        int c = 0;
        for (int i = 0; i < len; ++i) {
            if (s.charAt(i) == 'a') {
                c += 1;
            }
        }
        return c;
    }
    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        int aCount = getACount(s, s.length());
        long r = 0;
        r += (n / s.length()) * aCount;

        int len = (int)(n % s.length());
        r += getACount(s, len);

        return r;
    }