    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        if (head == null) {
            return newNode;
        }

        if (head.data > data) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }

        DoublyLinkedListNode h = head;

        while (h.next != null && h.data < data) {
            h = h.next;
        }


        if (h.data >= data) {
            h.prev.next = newNode;
            h.prev = newNode;
            newNode.prev = h.prev;
            newNode.next = h;
        } else {
            h.next = newNode;
            newNode.prev = h;
        }

        return head;
    }