    static int height(Node root, int height) {
        if (root == null) {
            return height - 1;
        }
        return Math.max(
                height(root.left, height + 1),
                height(root.right, height + 1));
    }
    public static int height(Node root) {
        return height(root, 0);
    }