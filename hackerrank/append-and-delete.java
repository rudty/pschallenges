    static String appendAndDelete(String s, String t, int k) {
        if (k - t.length() - s.length() >= 0) {
            return "Yes";
        }
        int maxLength = s.length();
        if (s.length() < t.length()) {
            String temp = s;
            s = t;
            t = temp;
            maxLength = s.length();
        }

        char[] sr = new char[maxLength];
        char[] tr = new char[maxLength];

        s.getChars(0, s.length(), sr, 0);
        t.getChars(0, t.length(), tr, 0);

        int firstRemoveOffset = 500;
        for (int i = 0; i < maxLength; ++i) {
            if (sr[i] != tr[i]) {
                firstRemoveOffset = i;
                break;
            }
        }
        if (firstRemoveOffset == 500) {
            if (k % 2 == 0) {
                return "Yes";
            }
            return "No";
        } else {
            int removeCount = t.length() - firstRemoveOffset;
            int appendCount = s.length() - firstRemoveOffset;
//            System.out.println(removeCount + " " + appendCount);
            if (removeCount + appendCount == k) {
                return "Yes";
            }
            int d = k - (removeCount + appendCount);
            if (d > 0 && d % 2 == 0) {
                return "Yes";
            }

            return "No";
        }
    }
