    static String[] cavityMap(String[] grid) {
        char[][] gridChar = new char[grid.length][];
        for (int i = 0; i < grid.length; ++i) {
            gridChar[i] = grid[i].toCharArray();
        }

        for (int y = 1; y < gridChar.length - 1; ++y) {
            for (int x = 1; x < gridChar[y].length - 1; ++x) {
                char e = gridChar[y][x];

                if (e > gridChar[y][x - 1] &&
                        e > gridChar[y][x + 1] &&
                        e > gridChar[y - 1][x] &&
                        e > gridChar[y + 1][x]) {
                    gridChar[y][x] = 'X';
                }
            }
        }

        String[] result = new String[grid.length];
        for (int i = 0; i < grid.length; ++i) {
            result[i] = new String(gridChar[i]);
        }
        return result;
    }
