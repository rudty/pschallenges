import java.util.Arrays;
import java.util.TreeMap;
class Solution {
        class Node {
        boolean isEnd = false;
        char value;
        TreeMap<Character, Node> children = new TreeMap<>();

        public Node(char value) {
            this.value = value;
        }

        private boolean add(String s, int index) {
            char c = s.charAt(index);
            Node n = children.computeIfAbsent(c, Node::new);
            if (s.length() - 1 == index) {
                if (n.isEnd || n.children.size() > 0) {
                    return false;
                } else {
                    n.isEnd = true;
                    return true;
                }
            }
            return n.add(s, index + 1);
        }
        public boolean add(String s) {
            return add(s, 0);
        }
    }

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, (l, r) -> {
            if (l.length() != r.length()) {
                return l.length() - r.length();
            }
            return l.compareTo(r);
        });

        Node root = new Node(' ');
        for (int i = phone_book.length - 1; i >= 0; --i) {
            if (!root.add(phone_book[i])) {
                return false;
            }
        }
        return true;
    }
}