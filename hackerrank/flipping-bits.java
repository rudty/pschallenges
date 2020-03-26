    static long flippingBits(long n) {
        for (int i = 0 ; i < 32; ++i) {
            long e = 1L << i;
            n ^= e;
        }
        return n;
    }
