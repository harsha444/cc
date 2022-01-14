package facebook.lc;

public class StringCompression {
    public static int compress(char[] chars) {
        int result = 0;
        StringBuilder resp = new StringBuilder();
        if (chars.length == 0 || chars.length == 1) {
            return chars.length;
        }
        char startChar = chars[0];
        int startCharOccurances = 1;
        for (int i = 1; i < chars.length; i++) {
            char currChar = chars[i];
            if (currChar != startChar) {
                startChar = currChar;
                resp.append(currChar);
                if (startCharOccurances > 1) {
                    resp.append(startCharOccurances);
                }
                startCharOccurances = 1;
            }
            if (i == chars.length - 1) {

            }
            startCharOccurances += 1;
        }
        return result;
    }

    public static int compress2(char[] chars) {
        StringBuilder resp = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < chars.length; ) {
            char currChar = chars[i];
            int nOccurances = 0;
            int j = i;
            while (j < chars.length && chars[j] == chars[i]) {
                nOccurances += 1;
                j++;
            }
            chars[idx] = currChar;
            resp.append(currChar);
            idx += 1;
            if (nOccurances > 1) {
                char[] numbsArr = String.valueOf(nOccurances).toCharArray();
                for (char num : numbsArr) {
                    chars[idx] = num;
                    idx += 1;
                }
            }
            i += nOccurances;
        }
        return idx;
    }

    public static void main(String[] args) {
        System.out.println(compress2(new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' }));
    }
}