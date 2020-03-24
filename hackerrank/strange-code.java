    static long strangeCounter(long t) {
        long a = 3;
        long it = 1;
        long mul = 1;
        int run = 0;
        while (true) {
            long c = it + 3 * mul;
            if (c > t) {
                break;
            }
            a *= 2;
            mul *= 2;
            it = c;
            run += 1;
        }
//        System.out.println(run);
        a -= (t - it);

        return a;
    }