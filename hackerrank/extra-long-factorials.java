    static void extraLongFactorials(int n) {
        BigInteger b = new BigInteger("1");
        for (int i = n; i > 0; --i) {
            b = b.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println(b);
    }