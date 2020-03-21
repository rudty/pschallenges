    static boolean findNode(Node root, int v) {
        if (root == null) {
            return false;
        }
        if (root.data == v) {
            return true;
        }
        return findNode(root.left, v) || findNode(root.right, v);
    }
    public static Node lca(Node root, int v1, int v2) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(root);
        Node lastFound = root;
        while (!q.isEmpty()) {
            Node n = q.pollFirst();
            if (n != null) {
                if (findNode(n, v1) && findNode(n, v2)) {
                    lastFound = n;
                    q.add(n.left);
                    q.add(n.right);
                }
            }

        }
        return lastFound;
    }