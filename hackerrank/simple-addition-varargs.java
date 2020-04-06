class Add {
    public void add(int... args) {
        int sum = args[0];
        StringBuilder output = new StringBuilder();
        output.append(args[0]);
        for (int i = 1; i < args.length; ++i) {
            output.append("+").append(args[i]);
            sum += args[i];
        }
        System.out.println(output + "=" + sum);
    }
}