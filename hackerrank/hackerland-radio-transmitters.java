    static int hackerlandRadioTransmitters(int[] x, int k) {
        Arrays.sort(x);
//        System.out.println(Arrays.toString(x));
        int require = 0;
        int last;
        for (int i = 0; i < x.length;) {
            require += 1;
            last = x[i];
            while (i < x.length && x[i] - last <= k) {
                ++i;
            }
            last = x[i - 1];
//            System.out.println(last);
            while (i < x.length && x[i] - last <= k) {
                ++i;
            }
        }
        return require;
    }
