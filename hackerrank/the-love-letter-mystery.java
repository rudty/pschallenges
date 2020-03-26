    static int theLoveLetterMystery(String s) {
        int half = s.length() / 2;
        int change = 0;
        for (int i = 0; i < half; ++i) {
            char cf = s.charAt(i);
            char cl = s.charAt(s.length() - i - 1);
            change += Math.abs(cf - cl);
        }
        return change;
    }
