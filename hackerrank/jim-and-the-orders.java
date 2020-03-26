    static int[] jimOrders(int[][] orders) {
        class IndexCostPair {
            int index;
            int cost;

            public IndexCostPair(int index, int cost) {
                this.index = index;
                this.cost = cost;
            }
        }

        return java.util.stream.IntStream.range(0, orders.length)
            .mapToObj(i -> new IndexCostPair(i + 1, orders[i][0] + orders[i][1]))
                .sorted((l, r) -> {
                    if (l.cost != r.cost) {
                        return l.cost - r.cost;
                    }
                    return l.index - r.index;
                })
                .mapToInt(e -> e.index)
                .toArray();
    }