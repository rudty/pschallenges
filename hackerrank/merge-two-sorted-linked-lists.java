        LinkedList<Integer> l = new LinkedList<>();
        while (head1 != null) {
            l.add(head1.data);
            head1 = head1.next;
        }
        while (head2 != null) {
            l.add(head2.data);
            head2 = head2.next;
        }
        Collections.sort(l);

        if (l.isEmpty()) {
            return null;
        }

        SinglyLinkedListNode newHead = new SinglyLinkedListNode(l.pop());
        SinglyLinkedListNode h = newHead;
        while (!l.isEmpty()) {
            h.next = new SinglyLinkedListNode(l.pop());
            h = h.next;
        }
        return newHead;