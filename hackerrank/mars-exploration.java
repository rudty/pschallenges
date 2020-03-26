  static int marsExploration(String s) {
        int diff = 0;
        for (int i = 0; i < s.length(); i += 3) {
            char s1 = s.charAt(i);
            char s2 = s.charAt(i + 1);
            char s3 = s.charAt(i + 2);
            if (s1 != 'S') {
                diff += 1;
            }
            if (s2 != 'O') {
                diff += 1;
            }
            if (s3 != 'S') {
                diff += 1;
            }

        }
        return diff;
    }