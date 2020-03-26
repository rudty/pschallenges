    // check first 1 and get '0' count
    // 0: 0     = 0
    // 1: 1     = 0
    // 2: 10    = 1
    // 3: 11    = 0
    // 4: 100   = 2
    // 5: 101   = 1
    // 6: 110   = 1
    // 7: 111   = 0
    // 8: 1000  = 3
    // 9: 1001  = 2
    // 10: 1010 = 2
    // 11: 1011 = 1
    // 12: 1100 = 2
    // 13: 1101 = 1
    // 14: 1110 = 1
    // 15: 1111 = 0
    static long sumXor(long n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 == 0) {
                count += 1;
            }
            n /= 2;
        }
        return (long)Math.pow(2, count);
    }
