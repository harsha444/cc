package educative.twopointers;

public class BackspaceStringCompare {
    private static int getNextValidChar(String s, int i) {
        int count = 0;
        while (i >= 0) {
            if (s.charAt(i) == '#') {
                count++;
            } else if (count > 0) {
                count--;
            } else {
                break;
            }
            i--;
        }
        return i;
    }

    public static boolean backspaceCompare(String s, String t) {
        int sEnd = s.length() - 1;
        int tEnd = t.length() - 1;
        while (sEnd >= 0 && tEnd >= 0) {
            int nextValidSChar = getNextValidChar(s, sEnd);
            int nextValidTChar = getNextValidChar(t, tEnd);
            if (nextValidSChar < 0 && nextValidTChar < 0) {
                return true;
            }
            if (nextValidSChar < 0 || nextValidTChar < 0) {
                return false;
            }
            if (s.charAt(nextValidSChar) != t.charAt(nextValidTChar)) {
                return false;
            }
            sEnd = nextValidSChar - 1;
            tEnd = nextValidTChar - 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("adad##", "#afaf#a##"));
    }
}
