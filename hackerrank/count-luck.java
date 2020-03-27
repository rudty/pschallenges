    static class XYPair {
        int x;
        int y;
        int waveCount;

        public XYPair(int x, int y, int waveCount) {
            this.x = x;
            this.y = y;
            this.waveCount = waveCount;
        }
    }

    static boolean isMapPosition(char[][] m, int x, int y) {
        return x >= 0 &&
                y >= 0 &&
                y < m.length &&
                x < m[y].length;
    }

    static boolean canGo(char[][] m, int x, int y) {
        return isMapPosition(m, x, y) && (m[y][x] == '.' || m[y][x] == '*');
    }
    static boolean isEnd(char[][] m, int x, int y) {
        return isMapPosition(m, x, y) && m[y][x] == '*';
    }

    // Complete the countLuck function below.
    static String countLuck(String[] matrix, int k) {
        char[][] m = new char[matrix.length][];
        LinkedList<XYPair> q = new LinkedList<>();

        for (int i = 0; i < matrix.length; ++i) {
            m[i] = matrix[i].toCharArray();
            for (int j = 0; j < m[i].length; ++j) {
                if (m[i][j] == 'M') {
                    q.add(new XYPair(j, i, 0));
                    m[i][j] = 'X';
                }
            }
        }

        while (!q.isEmpty()) {
            XYPair n = q.pollFirst();

            int canGoCount = 0;
            XYPair[] insertArray = new XYPair[4];

            if (isEnd(m, n.x, n.y)) {
                if (n.waveCount == k) {
                    return "Impressed";
                } else {
                    return "Oops!";
                }
            }

            m[n.y][n.x] = 'X';

            if (canGo(m, n.x - 1, n.y)) {
                canGoCount += 1;
                insertArray[0] = new XYPair(n.x - 1, n.y, n.waveCount);
                q.add(insertArray[0]);
            }
            if (canGo(m, n.x + 1, n.y)) {
                canGoCount += 1;
                insertArray[1] = new XYPair(n.x + 1, n.y, n.waveCount);
                q.add(insertArray[1]);
            }
            if (canGo(m, n.x, n.y - 1)) {
                canGoCount += 1;
                insertArray[2] = new XYPair(n.x, n.y - 1, n.waveCount);
                q.add(insertArray[2]);
            }
            if (canGo(m, n.x, n.y + 1)) {
                canGoCount += 1;
                insertArray[3] = new XYPair(n.x, n.y + 1, n.waveCount);
                q.add(insertArray[3]);
            }

            if (canGoCount > 1) {
                for (int i = 0; i < 4; ++i) {
                    if (insertArray[i] != null) {
                        insertArray[i].waveCount += 1;
                    }
                }
            }
        }

        throw new RuntimeException("?");
    }
