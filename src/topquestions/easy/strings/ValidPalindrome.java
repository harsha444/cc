package topquestions.easy.strings;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        String t = s.toLowerCase().replaceAll(" ", "");
        char[] c = t.toCharArray();
        int len = c.length;
        for (int i = 0, j = len - 1; i < j; ) {
            if (!Character.isLetterOrDigit(c[i])) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(c[j])) {
                j--;
                continue;
            }
            if (c[i] != c[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A ppa"));
    }
}
