    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (root.data < data) {
            if (root.right == null) {
                root.right = new Node(data);
                root.right.data = data;
            } else {
                insert(root.right, data);
            }
        } else {
            if (root.left == null) {
                root.left = new Node(data);
                root.left.data = data;
            } else {
                insert(root.left, data);
            }
        }
        return root;
    }