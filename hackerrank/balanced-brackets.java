    static String isBalanced(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            switch (c) {
                case '{':
                case '[':
                case '(':
                    stack.add(c);
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pollLast() != '{') {
                        return "NO";
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pollLast() != '[') {
                        return "NO";
                    }
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pollLast() != '(') {
                        return "NO";
                    }
                    break;
            }
        }
        if (!stack.isEmpty()) {
            return "NO";
        }
        return "YES";
    }