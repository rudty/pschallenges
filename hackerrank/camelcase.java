    static int camelcase(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if ('A' <= c && c <= 'Z') {
                count += 1;
            }
        }

        return count + 1;
    }