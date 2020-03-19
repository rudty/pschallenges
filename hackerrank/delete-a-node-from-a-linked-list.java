    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        if (head == null) {
            return null;
        }
        if (position == 0) {
            return head.next;
        }

        SinglyLinkedListNode h = head;
        for (int i = 0; i < position - 1 && h.next != null; ++i) {
            h = h.next;
        }

        SinglyLinkedListNode c = h.next;
        if (c != null && c.next != null) {
            h.next = c.next;
        }

        return head;
    }