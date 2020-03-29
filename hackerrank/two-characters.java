   static int calcStringLength(String newString) {
        if (newString.length() >= 2) {
            char lastChar = newString.charAt(0);
            for (int j = 1; j < newString.length(); ++j) {
                char e = newString.charAt(j);
                if (lastChar == e) {
                    return 0;
                }
                lastChar = e;
            }
            return newString.length();
        }
        return 0;
    }
    // Complete the alternate function below.
    static int alternate(String s) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            alphabet[s.charAt(i) - 'a'] += 1;
        }

        int maxNewStringLength = 0;
        for (int i = 0; i < 26; ++i) {
            for (int j = 1; j < 26; ++j) {
                if (i == j) {
                    continue;
                }
                if (alphabet[i] > 0 && alphabet[j] > 0) {
                    char removeChar1 = (char)(i + 'a');
                    char removeChar2 = (char)(j + 'a');
                    String removeCharPattern = "[^" + removeChar1 + removeChar2 + "]";
                    String newString = s.replaceAll(removeCharPattern, "");
                    maxNewStringLength = Math.max(maxNewStringLength, calcStringLength(newString));
                }
            }
        }
        return maxNewStringLength;
    }