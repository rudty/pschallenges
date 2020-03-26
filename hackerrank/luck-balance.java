    static int luckBalance(int k, int[][] contests) {
        ArrayList<Integer> importantContest = new ArrayList<>(contests.length);
        int nonImportantContestLuck = 0;

        for (int i = 0; i < contests.length; ++i) {
            int[] e = contests[i];
            if (e[1] == 0) {
                nonImportantContestLuck += e[0];
            } else {
                importantContest.add(e[0]);
            }
        }

        importantContest.sort((a, b) -> b - a);

        int luck = nonImportantContestLuck;

        k = Math.min(k, importantContest.size());
        for (int i = 0; i < k; ++i) {
            luck += importantContest.get(i);
        }

        for (int i = k; i < importantContest.size(); ++i) {
            luck -= importantContest.get(i);
        }

        return luck;
    }
