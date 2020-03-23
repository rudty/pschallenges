    static int[] permutationEquation(int[] p) {
       int[] rev = new int[p.length + 1];
        for (int i = 0; i < p.length; ++i) {
            rev[p[i]] = i + 1;
        }
        
        int[] result = new int[p.length];
        for (int i = 1; i <= p.length; ++i) {
            result[i - 1] = rev[rev[i]];
        }
        return result;
    }
