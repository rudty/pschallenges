    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        SinglyLinkedListNode h = head.next;
        SinglyLinkedListNode lastNode = head;
        while (h != null) {
            if (lastNode.data == h.data) {
                lastNode.next = h.next;
            } else {
                lastNode = h;
            }
            h = h.next;
        }
        return head;
    }
