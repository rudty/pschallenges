  static String funnyString(String s) {
          char[] c = s.toCharArray();
        int [] diffs = new int[c.length - 1];
        for (int i = 1; i < c.length; ++i) {
            int d = Math.abs(c[i - 1] - c[i]);
            diffs[i - 1] = d;
        }

        int half = diffs.length / 2;
        for (int i = 0; i < half; ++i) {
            if (diffs[i] != diffs[diffs.length - i - 1]) {
                return "Not Funny";
            }
        }
        return "Funny";
    }
