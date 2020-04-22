import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class XyPair {
        int x;
        int y;

        public XyPair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] check = new boolean[m][n];
        for (int i = 0; i < picture.length; ++i) {
            for (int j = 0; j < picture[i].length; ++j) {
                if (picture[i][j] != 0 && check[i][j] == false) {
                    numberOfArea += 1;
                    int size = 0;
                    Queue<XyPair> q = new LinkedList<>();
                    q.add(new XyPair(j, i));


                    while (!q.isEmpty()) {
                        XyPair p = q.poll();
                        if (p.x < 0 || p.y < 0 || p.y >= m || p.x >= n || check[p.y][p.x] || picture[i][j] != picture[p.y][p.x]) {
                            continue;
                        }

                        check[p.y][p.x] = true;
                        size += 1;

                        q.add(new XyPair(p.x - 1, p.y));
                        q.add(new XyPair(p.x + 1, p.y));
                        q.add(new XyPair(p.x, p.y + 1));
                        q.add(new XyPair(p.x, p.y - 1));
                    }

                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea; 
        return answer;
    }

}