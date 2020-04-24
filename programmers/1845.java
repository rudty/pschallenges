class Solution {
    public int solution(int[] nums) {
        java.util.HashSet<Integer> s = new java.util.HashSet<>();
        for (int e : nums) {
            s.add(e);
        }
        return Math.min(nums.length / 2, s.size());
    }
}