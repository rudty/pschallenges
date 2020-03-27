    static String[] TIMES = {
            "o' clock",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "quarter", // fifteen
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen",
            "twenty",
            "twenty one",
            "twenty two",
            "twenty three",
            "twenty four",
            "twenty five",
            "twenty six",
            "twenty seven",
            "twenty eight",
            "twenty nine",
            "half", // thirty
    };

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        if (m == 0) {
            return TIMES[h] + " " + TIMES[0];
        }

        String minute = " minutes ";
        if (m == 1) {
            minute = " minute ";
        }

        if (m == 15 || m == 30) {
            return TIMES[m] + " past " + TIMES[h];
        }

        if (m < 30) {
            return TIMES[m] + minute + "past " + TIMES[h];
        }

        m = 60 - m;
        h += 1;
        if (h > 12) {
            h -= 12;
        }

        if (m == 15) {
            return TIMES[15] + " to " + TIMES[h];
        }

        return TIMES[m] + minute + "to " + TIMES[h];
    }
