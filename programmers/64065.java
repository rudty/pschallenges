class Solution {
    public int[] solution(String s) {
         return java.util.Arrays.stream(s.split("(\\},\\{)|(\\{\\{)|(\\}\\})"))
                .filter(e -> !e.isEmpty())
                .sorted((a, b) -> a.length() - b.length())
                .map(e -> e.split(","))
                 .flatMapToInt(e -> java.util.Arrays.stream(e).mapToInt(Integer::parseInt))
                .distinct()
                .toArray();
    }
}