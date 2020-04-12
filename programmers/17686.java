import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    static Pattern headNumberPattern = Pattern.compile("([^0-9]+)([0-9]+)");
    static class FileName {
        String head = "";
        int number = 0;

        public FileName(String s) {
            Matcher m = headNumberPattern.matcher(s);
            m.find();

            head = m.group(1).toLowerCase();
            number = Integer.parseInt(m.group(2));
        }
    }

    public String[] solution(String[] files) {
        Arrays.sort(files, (l, r) -> {
            FileName fileNameL = new FileName(l);
            FileName fileNameR = new FileName(r);
            
            if (fileNameL.head.equals(fileNameR.head)) {
                return fileNameL.number - fileNameR.number;
            }
            return fileNameL.head.compareTo(fileNameR.head);
        });

        return files;
    }

}