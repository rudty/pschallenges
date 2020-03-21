    static int cookies(int k, int[] A) {
        /*
         * Write your code here.
         */
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < A.length; ++i) {
            q.add(A[i]);
        }
        if (q.isEmpty() || q.peek() >= k) {
            return 0;
        }
        int run = 0;
        while (q.size() >= 2) {
            int f = q.poll();
            if (f >= k) {
                return run;
            }
            int s = q.poll();

            q.add(f + 2 * s);

            run += 1;
        }
        if (q.peek() >= k) {
            return run;
        }
        return -1;
    }