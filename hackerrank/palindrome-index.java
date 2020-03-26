    static boolean checkAll(String s, int beginIndex, int endIndex) {
        while (beginIndex < endIndex) {
            if (s.charAt(beginIndex) != s.charAt(endIndex)) {
                return false;
            }
            beginIndex += 1;
            endIndex -= 1;
        }
        return true;
    }
    // Complete the palindromeIndex function below.
    static int palindromeIndex(String s) {
        int half = s.length() / 2;
        for (int i = 0; i < half; ++i) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(s.length() - i - 1);
            if (c1 != c2) {
                if (checkAll(s, i + 1, s.length() - i - 1)) {
                    return i;
                }
                return s.length() - i - 1;
            }
        }
        return -1;
    }