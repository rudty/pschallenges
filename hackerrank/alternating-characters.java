    static int alternatingCharacters(String s) {
        int deletions = 0;
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); ++i) {
            char e = s.charAt(i);
            if (c == e) {
                deletions += 1;
            }
            c = e;
        }
        return deletions;
    }
