    static void kaprekarNumbers(int p, int q) {
        boolean print = false;
        for (int i = p; i <= q; ++i) {
            long pow = (long)i * (long)i;
            String stringNum = String.valueOf(pow);
            int half = stringNum.length() / 2;
            String lhsString = stringNum.substring(0, half);
            String rhsString = stringNum.substring(half);

            int lhs = 0;
            if (lhsString.length() > 0) {
                lhs = Integer.parseInt(lhsString);
            }
            int rhs = 0;
            if (rhsString.length() > 0) {
                rhs = Integer.parseInt(rhsString);
            }

            if (lhs + rhs == i) {
                print = true;
                System.out.print(i + " ");
            }
        }

        if (!print) {
            System.out.println("INVALID RANGE");
        }
    }
