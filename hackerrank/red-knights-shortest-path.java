    static class Step {
        int x;
        int y;
        String step;
        int run;
        public Step(int x, int y, String step, int run) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.run = run;
        }
    }

    static Step[] NEXT_POS = new Step[] {
            new Step( -1, -2 , "UL ", 1),
            new Step( 1, -2 , "UR ", 1),
            new Step( 2, 0 , "R ", 1),
            new Step( 1, 2 , "LR ", 1),
            new Step( -1, 2 , "LL ", 1),
            new Step( -2, 0 , "L ", 1),
    };

    static boolean isMapPosition(int[][] m, Step s) {
        return s.x >= 0 &&
                s.y >= 0 &&
                s.y < m.length &&
                s.x < m[s.y].length;
    }

    // Complete the printShortestPath function below.
    static void printShortestPath(int n, int beginY, int beginX, int endY, int endX) {
        int[][] m = new int[n][n];

        LinkedList<Step> q = new LinkedList<>();
        q.add(new Step(beginX, beginY, "", 0));

        while (!q.isEmpty()) {
            Step s = q.poll();
            if (s.y == endY && s.x == endX) {
                System.out.println(s.run);
                System.out.println(s.step);
                return;
            }
            if (isMapPosition(m, s) && m[s.y][s.x] == 0) {
                m[s.y][s.x] = 1;
                for (Step np : NEXT_POS) {
                    q.add(new Step(
                            s.x + np.x,
                            s.y + np.y,
                            s.step + np.step,
                            s.run + np.run));
                }
            }
        }

        System.out.println("Impossible");
    }