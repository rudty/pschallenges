class Solution {
    public int solution(int[] scoville, int K) {
        java.util.PriorityQueue<Integer> q = new java.util.PriorityQueue<>();
        for (int e : scoville) {
            q.add(e);
        }
        int step = 0;
        while (true) {
            int firstValue = q.poll();
            if (firstValue >= K) {
                return step;
            }
            if (q.isEmpty()) {
                return -1;
            }
            int secondValue = q.poll();

            q.add(firstValue + secondValue * 2);
            step += 1;
        }
    }
}