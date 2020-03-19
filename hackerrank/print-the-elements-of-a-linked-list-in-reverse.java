    static void reversePrint(SinglyLinkedListNode head) {
        Stack<Integer> s = new Stack<>();
        while (head != null) {
            s.push(head.data);
            head = head.next;
        }
        while (!s.empty()) {
            System.out.println(s.pop());
        }
    }