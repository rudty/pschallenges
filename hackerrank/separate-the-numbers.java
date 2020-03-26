    static boolean findAllNumbers(String s, long n) {
        int it = 0;
        while (it < s.length()) {
            String num = String.valueOf(n);
            if (!s.startsWith(num, it)) {
                return false;
            }
            it += num.length();
            n += 1;
        }
        return it == s.length();
    }

    static void separateNumbers(String s) {
        int half = s.length() / 2;
        for (int i = 1; i <= half ; ++i) {
            String a = s.substring(0, i);
            long num = Long.parseLong(a);
            if (findAllNumbers(s, num)) {
                System.out.println("YES " + num);
                return;
            }
        }
        System.out.println("NO");
    }
