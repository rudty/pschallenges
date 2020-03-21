    static class Node {
        int data;
        int depth;
        Node parent;
        Node left = null;
        Node right = null;

        public Node(Node parent, int depth, int data) {
            this.parent = parent;
            this.data = data;
            this.depth = depth;
        }

        public int getDepth() {
            return depth;
        }

        public void swapChild() {
            Node temp = left;
            left = right;
            right = temp;
        }
    }

    static void outputNodes(LinkedList<Integer> o, Node n) {
        if (n != null && n.data != -1) {
            outputNodes(o, n.left);
            o.add(n.data);
            outputNodes(o, n.right);
        }
    }

    static int[][] swapNodes(int[][] indexes, int[] queries) {
        /*
         * Write your code here.
         */
        Node root = new Node(null, 1, 1);
        TreeMap<Integer, LinkedList<Node>> depthMap = new TreeMap<>();
        LinkedList<Node> leapNodeParents = new LinkedList<>();
        leapNodeParents.add(root);

        LinkedList<Node> rootDepth = new LinkedList<>();
        rootDepth.add(root);
        depthMap.put(1, rootDepth);

        int maxDepth = 1;
        for (int[] indexLR : indexes) {
            Node n = leapNodeParents.pollFirst();
            int childDepth = n.getDepth() + 1;
            maxDepth = Math.max(maxDepth, childDepth);

            if (!depthMap.containsKey(childDepth)) {
                depthMap.put(childDepth, new LinkedList<Node>());
            }
            LinkedList<Node> depthNodes = depthMap.get(childDepth);

            if (indexLR[0] != -1) {
                n.left = new Node(n, childDepth, indexLR[0]);
                depthNodes.add(n.left);
                leapNodeParents.add(n.left);
            }

            if (indexLR[1] != -1) {
                n.right = new Node(n, childDepth, indexLR[1]);
                depthNodes.add(n.right);
                leapNodeParents.add(n.right);
            }
        }

        leapNodeParents.clear();
        leapNodeParents = null;

        int[][] result = new int[queries.length][];
        for (int q = 0; q < queries.length; ++q) {
            int query = queries[q];

            LinkedList<Integer> output = new LinkedList<>();
            for (int i = query; i <= maxDepth; ++i) {
                if (i % query == 0) {
                    List<Node> dest = depthMap.get(i);
                    for (Node n : dest) {
                        n.swapChild();
                    }
                }
            }
            outputNodes(output, root);
            result[q] = output.stream().mapToInt(e -> e).toArray();
        }
        return result;
    }
