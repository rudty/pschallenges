    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        while (head1 != null) {
            SinglyLinkedListNode h = head2;
            while (h != null) {
                if (h == head1) {
                    return h.data;
                }
                h = h.next;
            }
            head1 = head1.next;
        }
        throw new RuntimeException("?");
    }