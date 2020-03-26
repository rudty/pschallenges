    static long marcsCakewalk(int[] calorie) {
        Arrays.sort(calorie);
        long r = 0;

        for (int i = 0; i < calorie.length; ++i) {
            r += calorie[calorie.length - i - 1] * (long)Math.pow(2, i);
        }

        return r;
    }