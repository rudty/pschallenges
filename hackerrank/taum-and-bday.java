    public static long taumBday(int b, int w, int bc, int wc, int z) {
        if (bc > wc + z) {
            long r = (b + w);
            r *= wc;
            r += ((long)b * z);
            return r;
        }

        if (wc > bc + z) {
            long r = (b + w);
            r *= bc;
            r += ((long)w * z);
            return r;
        }

        return (long)b * bc + (long)w * wc;
    }