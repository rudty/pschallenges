    static boolean findGrid(String[] G, String[] P, int findY, int findX) {
        for (int i = 0; i < P.length; ++i) {
            for (int j = 0; j < P[i].length(); ++j) {
                if (P[i].charAt(j) != G[i + findY].charAt(j + findX)) {
                    return false;
                }
            }
        }
        return true;
    }
    // Complete the gridSearch function below.
    static String gridSearch(String[] G, String[] P) {
        int lenY = G.length - P.length + 1;
        for (int i = 0; i < lenY; ++i) {
            int lenX = G[i].length() - P[0].length() + 1;
            for (int j = 0; j < lenX; ++j) {
                if(findGrid(G, P, i, j)) {
                    return "YES";
                }
            }
        }
        return "NO";
    }
