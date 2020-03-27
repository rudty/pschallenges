    static String biggerIsGreater(String w) {
        // 1. find c[i] > c[i - 1] value => minIndex
        // 2. find i = minIndex + 1; c[minIndex] < c[i] and minimum(c[i]);
        // 3. swap
        // 4. sort

        char[] c = w.toCharArray();
        int minIndex = -1;
        for (int i =  w.length() - 1; i > 0; --i) {
            if (c[i] > c[i - 1]) {
                minIndex = i - 1;
                break;
            }
        }
        if (minIndex == -1) {
            return "no answer";
        }

        int nextMinIndex = minIndex + 1;
        char nextMinValue = c[nextMinIndex];
        for (int i = minIndex + 1; i < c.length; ++i) {
            if (c[minIndex] < c[i]) {
                if (nextMinValue > c[i]) {
                    nextMinIndex = i;
                    nextMinValue = c[i];
                }
            }
        }

        c[nextMinIndex] = c[minIndex];
        c[minIndex] = nextMinValue;
        Arrays.sort(c, minIndex + 1, c.length);

        return new String(c);
    }