import java.util.*;
import java.util.logging.ConsoleHandler;

class Solution {
    class Node {
        int to;
        int moveCount;

        public Node(int to, int moveCount) {
            this.to = to;
            this.moveCount = moveCount;
        }
    }
    public int solution(int n, int[][] edge) {
        ArrayList<LinkedList<Integer>> allNode = new ArrayList<>(n + 2);
        for (int i = 0; i < edge.length; ++i) {
            allNode.add(new LinkedList<>());
        }

        for (int[] e : edge) {
            allNode.get(e[0]).add(e[1]);
            allNode.get(e[1]).add(e[0]);
        }


        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        boolean[] visit = new boolean[n + 2];
        visit[1] = true;

        LinkedList<Node> q = new LinkedList<>();
        for (int i = 0; i < allNode.get(1).size(); ++i) {
            for (int e : allNode.get(1)) {
                q.add(new Node(e, 0));
            }
        }

        while (!q.isEmpty()) {
            Node c = q.pollFirst();
            if (!visit[c.to]) {
                visit[c.to] = true;
                countMap.put(c.moveCount, countMap.getOrDefault(c.moveCount, 0) + 1);
                for (int e : allNode.get(c.to)) {
                    q.add(new Node(e, c.moveCount + 1));
                }
            }
        }
        return countMap.lastEntry().getValue();
    }
}