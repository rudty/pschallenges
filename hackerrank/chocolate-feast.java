    // Complete the chocolateFeast function below.
    static int chocolateFeast(int n, int c, int m) {
        int eatChocolate = n / c;
        int wrapper = eatChocolate;

        while (wrapper >= m) {
            wrapper -= m;
            wrapper += 1;
            eatChocolate += 1;
        }
        return eatChocolate;
    }
