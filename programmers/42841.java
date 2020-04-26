
class Solution {
    static boolean isNotGameNumber(int n) {
        int a = n % 10;
        n /= 10;
        int b = n % 10;
        n /= 10;
        int c = n % 10;
        if (a == 0 || b == 0 || c == 0) {
            return true;
        }
        return a == b || a == c || b == c;
    }

    static int strikeCount(int l, int r) {
        int strike = 0;
        for (int i = 0; i < 3; ++i) {
            int a = l % 10;
            int b = r % 10;
            if (a == b) {
                strike += 1;
            }
            l /= 10;
            r /= 10;
        }
        return strike;
    }

    static int ballCount(int l, int r) {
        int ball = 0;
        int[] al = new int[3];
        int[] bl = new int[3];
        for (int i = 0; i < 3; ++i) {
            al[i] = l % 10;
            bl[i] = r % 10;
            l /= 10;
            r /= 10;
        }

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (i == j) {
                    continue;
                }
                if (al[i] == bl[j]) {
                    ball += 1;
                }
            }
        }
        return ball;
    }

    public int solution(int[][] baseball) {

        int candidate = 0;
        for (int i = 123; i <= 987; ++i) {
            if (isNotGameNumber(i)) {
                continue;
            }
            System.out.println(i);
            boolean isMatch = true;
            for (int[] e : baseball) {
                int strike = strikeCount(e[0], i);
                int ball = ballCount(e[0], i);
                if (e[1] != strike || e[2] != ball) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                candidate += 1;
            }
        }
        return candidate;
    }
}