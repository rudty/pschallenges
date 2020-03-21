    public static void levelOrder(Node root) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node n = q.pollFirst();
            if (n != null) {
                System.out.print(n.data + " ");
                q.add(n.left);
                q.add(n.right);
            }
        }
    }
