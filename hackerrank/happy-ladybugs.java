
    static boolean checkCanMove(String b) {
        TreeMap<Character, Integer> m = new TreeMap<>();
        for (int i = 0; i < b.length(); ++i) {
            char c = b.charAt(i);
            m.put(c, m.getOrDefault(c, 0) + 1);
        }

        if (!m.containsKey('_')) {
            return false;
        }

        for (Map.Entry<Character, Integer> kv : m.entrySet()) {
            if (kv.getKey() == '_') {
                continue;
            }
            if (kv.getValue() < 2) {
                return false;
            }
        }
        return true;
    }

    static boolean checkAlign(String b) {
        int lastCount = 1;

        for (int i = 1; i < b.length(); ++i) {
            char before = b.charAt(i - 1);
            char current = b.charAt(i);
            if (before == current) {
                lastCount += 1;
            } else {
                if (lastCount < 2) {
                    return false;
                }
                lastCount = 1;
            }
        }
        return lastCount >= 2;
    }

    // Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {
        if (checkAlign(b) || checkCanMove(b)) {
            return "YES";
        }
        return "NO";
    }
