    static int[] stones(int n, int a, int b) {
        n -= 1;
        if (a == b) {
            return new int[] { a * n };
        }

        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        int beginIndex = a * n;
        int endIndex = b * n;
        int step = b - a;

        LinkedList<Integer> l = new LinkedList<>();
        for (int i = beginIndex; i <= endIndex; i += step) {
            l.add(i);
        }
        return l.stream().mapToInt(e -> e).toArray();
    }
