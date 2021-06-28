package fb;

public class RomanToInteger {
    private static int getPriority(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }

    public static int romanToInt(String s) {
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char currChar = s.charAt(i);
            int currCharVal = getPriority(currChar);
            if (i == s.length() - 1) {
                result += currCharVal;
                continue;
            }
            char nextChar = s.charAt(i + 1);
            int nextCharValue = getPriority(nextChar);
            if (nextCharValue > currCharVal) {
                result -= currCharVal;
            } else {
                result += currCharVal;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }
}
