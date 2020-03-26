    static int lonelyinteger(int[] a) {
        int[] check = new int[101];
        for (int i = 0; i < a.length; ++i) {
            check[a[i]] += 1;
        }

        for (int i = 0; i < check.length; ++i) {
            if (check[i] == 1) {
                return i;
            }
        }
        return 0;
    }