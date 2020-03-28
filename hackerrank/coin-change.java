    public static long getWays(int n, List<Long> c) {
        // Write your code here
        long[] mem = new long[n + 1];
        int[] coins = c.stream().mapToInt(Long::intValue).sorted().toArray();
        mem[0] = 1;

        for (int coin : coins) {
            for(int i = coin; i <= n; ++i) {
                mem[i] += mem[i - coin];
            }
            //System.out.println(Arrays.toString(mem));
        }

      //  System.out.println(Arrays.toString(mem));
        return mem[n];
    }
