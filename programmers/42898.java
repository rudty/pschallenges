class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] maps = new int[n + 1][m + 1];
        int[][] mem = new int[n + 1][m + 1];

        for (int[] puddle : puddles) {
            maps[puddle[1] - 1][puddle[0] - 1] = 1;
        }

        mem[n - 1][m - 1] = 1;

        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                if (maps[i][j] == 1) {
                    continue;
                }
                mem[i][j] += (mem[i + 1][j] + mem[i][j + 1]) % 1000000007;
            }
        }
        return mem[0][0];
    }
}