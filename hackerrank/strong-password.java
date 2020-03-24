    static final String numbers = "0123456789";
    static final String lower_case = "abcdefghijklmnopqrstuvwxyz";
    static final String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String special_characters = "!@#$%^&*()-+";

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        boolean isOneDigit = false;
        boolean isLowerCase = false;
        boolean isUpperCase = false;
        boolean isSpecialCharacter = false;

        for (int i = 0; i < password.length(); ++i) {
            String e = "" + password.charAt(i);
            if (!isOneDigit && numbers.contains(e)) {
                isOneDigit = true;
            }
            if (!isLowerCase && lower_case.contains(e)) {
                isLowerCase = true;
            }
            if (!isUpperCase && upper_case.contains(e)) {
                isUpperCase = true;
            }
            if (!isSpecialCharacter && special_characters.contains(e)) {
                isSpecialCharacter = true;
            }
        }
        int requireLength = 0;
        if (!isOneDigit) {
            requireLength += 1;
        }
        if (!isLowerCase) {
            requireLength += 1;
        }
        if (!isUpperCase) {
            requireLength += 1;
        }
        if (!isSpecialCharacter) {
            requireLength += 1;
        }

        if (password.length() + requireLength < 6) {
            requireLength += 6 - requireLength - password.length();
        }
        return requireLength;
    }
