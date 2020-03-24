    // line:44  String result = fairRations(B);
    static String fairRations(int[] B) {
        int use = 0;
        for (int i = 0; i < B.length - 1; ++i) {
            if ((B[i] & 1) == 1) {
                use += 2;
                B[i + 1] += 1;
            }
        }
        if ((B[B.length - 1] & 1) == 1) {
            return "NO";
        }
        return String.valueOf(use);
    }