package facebook.lc;

public class ValidPalindromeII {
    private static boolean isPalindrome(char[] c, int i, int j) {
        while (i < j) {
            if (c[i] != c[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean validPalindrome(String s) {
        char[] c = s.toCharArray();
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (c[start] != c[end]) {
                return isPalindrome(c, start, end - 1) || isPalindrome(c, start + 1, end);
            }
            start += 1;
            end -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome("abc"));
    }
}
