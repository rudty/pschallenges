    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
     if (head == null) {
           return null;
       }

       while (head.next != null) {
           head = head.next;
       }

       DoublyLinkedListNode newHead = new DoublyLinkedListNode(head.data);
       DoublyLinkedListNode h = newHead;
       head = head.prev;
       while (head != null) {
           DoublyLinkedListNode newNode = new DoublyLinkedListNode(head.data);
           h.next = newNode;
           newNode.prev = h;

           h = h.next;
           head = head.prev;
       }


       return newHead;
    }