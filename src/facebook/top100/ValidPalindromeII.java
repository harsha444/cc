package facebook.top100;

public class ValidPalindromeII {
    private boolean isPalindrome(char[] c, int i, int j) {
        while (i < j) {
            if (c[i] != c[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        char[] c = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (c[i] != c[j]) {
                return isPalindrome(c, i, j - 1) || isPalindrome(c, i + 1, j);
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
