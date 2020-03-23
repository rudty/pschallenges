    static int saveThePrisoner(int n, int m, int s) {
        if (n < m) {
            m = m % n;
            if (m == 0) {
                m = n;
            }
        }
        s -= 1;
        long  r = m + s;
        if (r == 0) {
            return 1;
        }
        if (r <= n) {
            return (int)r;
        }
        return (int)(r % n);
    }