    static boolean isTriangle(long a, long b, long c) {
        if(c < a + b && b < a + c && a < b + c) {
            return true;
        }
        return false;
    }
    // Complete the maximumPerimeterTriangle function below.
    static int[] maximumPerimeterTriangle(int[] sticks) {
        long maxPerimeter = 0;
        int[] result = new int[] { -1 };
        for (int i = 0; i < sticks.length; ++i) {
            for (int j = 1; j < sticks.length; ++j) {
                if (i == j) {
                    continue;
                }
                for (int k = 2; k < sticks.length; ++k) {
                    if (j == k || i == k) {
                        continue;
                    }
                    int a = sticks[i];
                    int b = sticks[j];
                    int c = sticks[k];

                    if (isTriangle(a, b, c)) {
                        long perimeter = a;
                        perimeter += b;
                        perimeter += c;
                        if (maxPerimeter < perimeter) {
                            maxPerimeter = perimeter;
                            result = new int[] { a, b, c };
                        }
                    }
                }
            }
        }
        Arrays.sort(result);
        return result;
    }
