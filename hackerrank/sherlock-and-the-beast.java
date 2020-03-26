    static void decentNumber(int n) {
        boolean run = false;
        int n5 = 0;
        int n3 = 0;
        for (int num = n % 5; num <= n; num += 5) {
            if (num % 3 == 0) {
                run = true;
                n5 = (n - num) / 5;
                n3 = num / 3;
            }
        }
        if (run) {
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < n3; ++i) {
                output.append("555");
            }
            for (int i = 0; i < n5; ++i) {
                output.append("33333");
            }
            System.out.println(output);
        } else {
            System.out.println("-1");
        }
    }