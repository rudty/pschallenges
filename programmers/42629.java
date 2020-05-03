import java.util.*;
class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        int it = 0;
        int supplyCount = 0;
        for (int i = 1; i <= k; ++i) {
            if (stock == 0) {
                supplyCount += 1;
                stock += q.poll();
            }

            if (it < dates.length && dates[it] == i) {
                q.add(supplies[it]);
                it += 1;
            }
            
            stock -= 1;
        }
        return supplyCount;
    }
}