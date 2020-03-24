    // Complete the howManyGames function below.
    static int howManyGames(int p, int d, int m, int s) {
        // Return the number of games you can buy
        int count  = 0;
        while (s >= p) {
            s -= p;
            p -= d;
            p = Math.max(p, m);
            count += 1;
        }
        return count;
    }
