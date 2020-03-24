    static String pangrams(String s) {
        s = s.toLowerCase();
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            int c = s.charAt(i);
            if ('a' <= c && c <= 'z') {
                alphabet[c-'a'] = 1;
            }
        }

        if (Arrays.stream(alphabet).sum() == 26) {
            return "pangram";
        }
        return "not pangram";
    }