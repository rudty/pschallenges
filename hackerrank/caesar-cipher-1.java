    static String caesarCipher(String s, int k) {
        k %= 26;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; ++i) {
            if ('a' <= c[i] && c[i] <= 'z') {
                c[i] += k;
                if (c[i] > 'z') {
                    c[i] -= 26;
                }
            }
            if ('A' <= c[i] && c[i] <= 'Z') {
                c[i] += k;
                if (c[i] > 'Z') {
                    c[i] -= 26;
                }
            }
        }

        return new String(c);
    }