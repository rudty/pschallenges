    static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        if (head == null) {
            return 0;
        }
        List<Integer> l = new LinkedList<>();
        while (head != null){
            l.add(head.data);
            head = head.next;
        }
        return l.get(l.size() - positionFromTail - 1);
    }