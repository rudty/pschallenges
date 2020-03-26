   static char[][] makeEncryptMap(String trimString) {
        int columnLength = (int)Math.ceil(Math.sqrt(trimString.length()));
        int rowLength = trimString.length() / columnLength + 1;
        int it = 0;
        char[][] c = new char[rowLength][columnLength];
        for (int i = 0; i < rowLength; ++i) {
            for (int j = 0; j < columnLength; ++j) {
                c[i][j] = trimString.charAt(it++);
                if (it == trimString.length()) {
                    return c;
                }
            }
        }
        return c;
    }
    // Complete the encryption function below.
    static String encryption(String s) {
        String trimString = s.replaceAll(" ", "");
        char[][] c = makeEncryptMap(trimString);

        StringBuilder builder = new StringBuilder(trimString.length() + c.length + 1);
        for (int i = 0; i < c[0].length; ++i) {
            for (int j = 0; j < c.length; ++j) {
                if (c[j][i] != 0) {
                    builder.append(c[j][i]);
                }
            }
            builder.append(' ');
        }
        return builder.toString();
    }