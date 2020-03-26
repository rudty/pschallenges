    static int gemstones(String[] arr) {
        boolean[] use = new boolean[26];
        for (int i = 0; i < 26; ++i) {
            use[i] = true;
        }
        for (int i = 0; i < arr.length; ++i) {
            boolean[] alphabet = new boolean[26];
            for (int j = 0; j < arr[i].length(); ++j) {
                alphabet[arr[i].charAt(j) - 'a'] = true;
            }
            for (int j = 0; j < 26; ++j) {
                use[j] &= alphabet[j];
            }
        }

        int c = 0;
        for (int i = 0; i < 26; ++i) {
            if (use[i]) {
                c += 1;
            }
        }
        return c;
    }
