    static int stringConstruction(String s) {
        int dollar = 0;
        boolean[] alphabet = new boolean[26];
        for (int i = 0; i < s.length(); ++i) {
            int charCode = s.charAt(i) - 'a';
            if (!alphabet[charCode]) {
                dollar += 1;
                alphabet[charCode] = true;
            }
        }
        return dollar;
    }