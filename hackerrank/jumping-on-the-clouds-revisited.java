    static int jumpingOnClouds(int[] c, int k) {
        class IndexTypePair {
            int index;
            boolean cloudType;

            public IndexTypePair(int index, boolean cloudType) {
                this.index = index;
                this.cloudType = cloudType;
            }
        }

        LinkedList<IndexTypePair> queue = new LinkedList<>();
        for (int i = 0; i < c.length; ++i) {
            queue.add(new IndexTypePair(i, c[i] == 1));
        }

        int energy = 100;

        while (true) {
            for (int i = 0; i < k; ++i) {
                IndexTypePair n = queue.pollFirst();
                queue.add(n);
            }
            energy -= 1;
            IndexTypePair elem = queue.peekFirst();
            if (elem.cloudType) {
                energy -= 2;
            }
            if (elem.index == 0) {
                break;
            }

        }
        return energy;
    }
