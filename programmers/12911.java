class Solution {
    public int getCount(int n) {
        int count = 0;
        for (int i = 0; i < 32; ++i) {
            int a = 1 << i;
            if ((n & a) == a) {
                count += 1;
            }
        }
        return count;
    }
    public int solution(int n) {
        int bitCount = getCount(n);

        for (int i = n + 1;;++i) {
            if (getCount(i) == bitCount) {
                return i;
            }
        }
    }

}