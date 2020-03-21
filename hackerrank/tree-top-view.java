    public static void topView(Node root) {
        // https://www.youtube.com/watch?v=c3SAvcjWb1E
        class HdNodePair {
            public int hd;
            public Node node;

            public HdNodePair(int hd, Node node) {
                this.hd = hd;
                this.node = node;
            }
        }
        Map<Integer, Integer> m = new TreeMap<>();
        LinkedList<HdNodePair> queue = new LinkedList<>();
        queue.add(new HdNodePair(0, root));
        while (!queue.isEmpty()) {
            HdNodePair n = queue.pollFirst();
            if (n.node != null) {
                if (!m.containsKey(n.hd)) {
                    m.put(n.hd, n.node.data);
                }
                queue.add(new HdNodePair(n.hd - 1, n.node.left));
                queue.add(new HdNodePair(n.hd + 1, n.node.right));
            }
        }

        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            System.out.print(e.getValue() + " ");
        }
    }