import java.util.LinkedList;

class Solution {
    static class IndexValuePair {
        int index;
        int value;

        public IndexValuePair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    public int[] solution(int[] prices) {
        LinkedList<IndexValuePair> stack = new LinkedList<>();
        int[] result = new int[prices.length];
        for (int i = 0; i < prices.length; ++i) {
            IndexValuePair top = stack.peekFirst();
            while (top != null && top.value > prices[i]) {
                result[top.index] = i - top.index;
                stack.pop();
                top = stack.peekFirst();
            }

            stack.push(new IndexValuePair(i, prices[i]));
        }
        while (!stack.isEmpty()) {
            IndexValuePair top = stack.pop();
            result[top.index] = prices.length - top.index - 1;
        }
        return result;
    }
}