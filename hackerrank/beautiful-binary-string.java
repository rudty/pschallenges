    static int beautifulBinaryString(String b) {
        char[] arr = b.toCharArray();
        int change = 0;
        for (int i = 0; i < arr.length - 2; ++i) {
            char c1 = arr[i];
            char c2 = arr[i + 1];
            char c3 = arr[i + 2];

            if (c1 == '0' && c2 == '1' && c3 == '0') {
                change += 1;
                arr[i + 2] = '1';
            }
        }
        return change;
    }
