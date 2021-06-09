package fb;

public class Atoi {
    private static String trimInitialZeroes(String s) {
        int i = 0;
        while (i < s.length() && Character.isSpaceChar(s.charAt(i))) {
            i++;
        }
        return s.substring(i);
    }

    private static int getMultiplier(String s) {
        if (s.length() > 0 && s.charAt(0) == '-') {
            return -1;
        }
        return 1;
    }

    public static int myAtoi(String s) {
        int multiplier;
        long res = 0;
        s = trimInitialZeroes(s);
        multiplier = getMultiplier(s);
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
                continue;
            }
            if (!Character.isDigit(s.charAt(i))) {
                break;
            }
            char currChar = s.charAt(i);
            int intVal = currChar - '0';
            res = (res * 10L) + intVal;
            if (res > Integer.MAX_VALUE && multiplier >= 0) {
                return Integer.MAX_VALUE;
            }
            if (res > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int)res * multiplier;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("2147483646"));
        System.out.println(Integer.MIN_VALUE);
    }
}
