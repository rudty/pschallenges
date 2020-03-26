       char[] c = new char[200];
        s.getChars(0, s.length(), c, 0);

        boolean run = true;
        int length = s.length();
        while (run) {
            run = false;
            char before = c[0];
            for (int i = 1; i < length; ++i) {
                if (before == c[i]) {
                    for (int j = i + 1; j < length; ++j) {
                        c[j - 2] = c[j];
                    }
                    length -= 2;
                    run = true;
                }
                before = c[i];
            }
        }
        if (length == 0) {
            return "Empty String";
        }
        return new String(c, 0, length);