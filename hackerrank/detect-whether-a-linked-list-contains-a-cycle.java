    static boolean hasCycle(SinglyLinkedListNode head) {
        Set<Integer> l = new HashSet<>();
        while (head != null) {
            if (!l.add(head.hashCode())) {
                return true;
            }
            head = head.next;
        }
        return false;
    }