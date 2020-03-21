    static int[] primes = getPrimes();

    static int[] getPrimes() {
        List<Integer> primes = new LinkedList<>();
        boolean[] f = new boolean[20000];

        for (int i = 2; i < 20000; ++i) {
            if (!f[i]) {
                primes.add(i);
                for (int j = 2; (i * j) < 20000; ++j) {
                    f[i*j] = true;
                }
            }
        }
        return primes.stream().mapToInt(e -> e).toArray();
    }

    static LinkedList<Integer> stackA = new LinkedList<>();
    static TreeMap<Integer, LinkedList<Integer>> stackB = new TreeMap<>();

    static void addStack(int n, int q) {
        for (int i = 0; i < q; ++i) {
            if (n % primes[i] == 0) {
                if (!stackB.containsKey(primes[i])) {
                    stackB.put(primes[i], new LinkedList<>());
                }
                LinkedList<Integer> b = stackB.get(primes[i]);
                if (i % 2 != 0) {
                    b.add(n);
                } else {
                    b.addFirst(n);
                }
                return;
            }
        }
        stackA.addFirst(n);
    }
    /*
     * Complete the waiter function below.
     */
    static int[] waiter(int[] number, int q) {
        /*
         * Write your code here.
         */
        for (int n : number) {
            addStack(n, q);
        }

        System.out.println(stackA);
        int it = 0;
        int[] result = new int[number.length];

        while (!stackB.isEmpty()) {
            LinkedList<Integer> b = stackB.pollFirstEntry().getValue();
            while (!b.isEmpty()) {
                result[it++] = b.pollLast();
            }
        }
        while (!stackA.isEmpty()) {
            if (q % 2 == 0) {
                result[it++] = stackA.pollFirst();
            } else {
                result[it++] = stackA.pollLast();
            }
        }
        return result;
    }
