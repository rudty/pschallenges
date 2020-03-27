
    static class XyPair {
        int x;
        int y;

        public XyPair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int findMap(int[][] matrix, LinkedList<XyPair> q) {
        int w = 0;
        while (!q.isEmpty()) {
            XyPair p = q.pollFirst();
            if (p.y >= 0 &&
                    p.y < matrix.length &&
                    p.x >= 0 &&
                    p.x < matrix[p.y].length &&
                    matrix[p.y][p.x] == 1) {
                matrix[p.y][p.x] = 2;
                w += 1;
                q.add(new XyPair(p.x, p.y - 1));
                q.add(new XyPair(p.x, p.y + 1));
                q.add(new XyPair(p.x - 1, p.y));
                q.add(new XyPair(p.x + 1, p.y));

                q.add(new XyPair(p.x - 1, p.y - 1));
                q.add(new XyPair(p.x + 1, p.y - 1));
                q.add(new XyPair(p.x - 1, p.y + 1));
                q.add(new XyPair(p.x + 1, p.y + 1));
            }
        }
        return w;
    }

    // Complete the connectedCell function below.
    static int connectedCell(int[][] matrix) {
        LinkedList<XyPair> q = new LinkedList<>();
        int maxArea = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 1) {
                    q.add(new XyPair(j, i));
                    maxArea = Math.max(maxArea, findMap(matrix, q));
                }
            }
        }
        return maxArea;
    }
