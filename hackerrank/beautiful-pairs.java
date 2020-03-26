        int result = 0;
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int i = 0; i < A.length; ++i) {
            m.put(A[i], m.getOrDefault(A[i], 0) + 1);
        }
        for (int i = 0; i < B.length; ++i) {
            int k = m.getOrDefault(B[i], 0);
            if (k > 0) {
                result += 1;
                m.put(B[i], k - 1);
            }
        }

        // same => A: [1] [2]
        //         B: [1] [2] => [1] [1]
        //         result: 1
        //
        // diff => A: [1] [2]
        //         B: [1] [1] => [1] [2]
        //         result: 2
        if (result == A.length) {
            return result - 1;
        } else {
            return result + 1;
        }