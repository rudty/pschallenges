class Solution {
    int recur(int[] numbers, int it, int accum, int target) {
        if (it == numbers.length) {
            if (accum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        int cnt = 0;
        cnt += recur(numbers, it + 1, numbers[it] + accum, target);
        cnt += recur(numbers, it + 1, (-numbers[it]) + accum, target);
        return cnt;
    }
    public int solution(int[] numbers, int target) {
        int answer = recur(numbers, 0, 0, target);
        return answer;
    }
}