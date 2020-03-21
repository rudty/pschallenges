    static ArrayList<Integer> l = new ArrayList<>();
    void recur(Node n) {
        if (n != null) {
            recur(n.left);
            l.add(n.data);
            recur(n.right);
        }
    }
    public boolean checkBST(Node root) {
        recur(root);

        for (int i = 1; i < l.size(); ++i) {
            if (l.get(i) - l.get(i - 1) <= 0) {
                return false;
            }
        }
        return true;
    }