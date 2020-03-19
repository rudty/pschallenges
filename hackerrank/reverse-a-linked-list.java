    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        if (head == null) {
            return null;
        }

        Stack<Integer> s = new Stack<>();
        while (head != null) {
            s.push(head.data);
            head = head.next;
        }
        
        SinglyLinkedListNode newHead = new SinglyLinkedListNode(s.pop());
        SinglyLinkedListNode p = newHead;
        while (!s.empty()) {
            p.next = new SinglyLinkedListNode(s.pop());
            p = p.next;
        }
        return newHead;

    }
