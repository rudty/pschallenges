    void decode(String s, Node root) {
        Node h = root;
        for (int i = 0; i < s.length(); ++i) {
            switch (s.charAt(i)) {
                case '0':
                    h = h.left;
                    break;
                case '1':
                    h = h.right;
                    break;
            }

            if (h.data != 0) {
                System.out.print(h.data);
                h = root;
            }
        }
    }