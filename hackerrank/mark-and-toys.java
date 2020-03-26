    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        int buyCount = 0;
        for (int i = 0; i < prices.length; ++i) {
            k -= prices[i];
            if (k < 0) {
                break;
            }
            buyCount += 1;
        }

        return buyCount;
    }