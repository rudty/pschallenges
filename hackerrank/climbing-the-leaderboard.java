    static void arrayReverse(int[] a) {
        int half = a.length / 2;
        for (int i = 0; i < half; ++i) {
            int temp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = temp;
        }
    }

    static int aliceStep(int[] scores, int[] alice, int[] result, int score_i, int alice_i) {
        while (alice_i >= 0 && scores[score_i] <= alice[alice_i]) {
            result[alice_i] = score_i + 1;
            alice_i -= 1;
        }
        return alice_i;
    }
    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        scores = Arrays.stream(scores)
                .parallel() // :)
                .distinct()
                .sorted()
                .toArray();
        arrayReverse(scores);


        int[] result = new int[alice.length];
        int alice_i = alice.length - 1;

        for  (int score_i = 0; score_i < scores.length && alice_i >= 0; ++score_i) {
            alice_i = aliceStep(scores, alice, result, score_i, alice_i);
        }

        for (int i = alice_i; i >= 0; --i) {
            result[i] = scores.length + 1;
        }
        return result;
    }
