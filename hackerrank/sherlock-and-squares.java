    static int[] squareNumbers = new int[32000];
    static {
        int it = 0;
        int limit = (int)Math.pow(10, 9);
        for (int i = 1; ; ++i) {
            int pow = i * i;
            if (pow > limit) {
                break;
            }
            squareNumbers[it] = pow;
            it += 1;
        }
    }
    // Complete the squares function below.
    static int squares(int a, int b) {
        int c = 0;
        for (int i = 0; i < squareNumbers.length; ++i) {
            if (squareNumbers[i] > b) {
                break;
            }
            if (squareNumbers[i] >= a) {
                c += 1;
                a += 1;
            }
        }
        return c;
    }
