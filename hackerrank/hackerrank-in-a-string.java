    static String hackerrankInString(String s) {
      s = s.toLowerCase();
        Pattern p = Pattern.compile("[a-z]*h[a-z]*a[a-z]*c[a-z]*k[a-z]*e[a-z]*r[a-z]*r[a-z]*a[a-z]*n[a-z]*k[a-z]*");
        Matcher matcher = p.matcher(s);

        if (matcher.matches()) {
            return "YES";
        }
        return "NO";
    }