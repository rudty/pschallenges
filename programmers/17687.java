class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder builder = new StringBuilder(38951446);
        for (int i = 0; i <= 1000000; ++i) {
            builder.append(Integer.toString(i, n));
        }
        p -= 1;

        StringBuilder out = new StringBuilder();
        for (int i = 0; t > 0; ++i) {
            if (i % m == p) {
                out.append(builder.charAt(i));
                t -= 1;
            }
        }
        return out.toString().toUpperCase();
    }
}