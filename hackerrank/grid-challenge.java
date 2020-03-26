    static String gridChallenge(String[] grid) {
        char[][] c = new char[grid.length][];
        for (int i = 0; i < grid.length; ++i) {
            c[i] = grid[i].toCharArray();
            Arrays.sort(c[i]);
        }

        int width = c[0].length;
        int height = c.length;

        for (int i = 0; i < width; ++i) {
            for (int j = 1; j < height; ++j) {
                if (c[j][i] < c[j - 1][i]) {
                    return "NO";
                }
            }
        }
        return "YES";
    }
