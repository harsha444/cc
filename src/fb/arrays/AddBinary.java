package fb.arrays;

import java.math.BigDecimal;
import java.math.BigInteger;

public class AddBinary {
    private static int getSum(char a, char b, char carry) {
        return Integer.parseInt(String.valueOf(a)) + Integer.parseInt(String.valueOf(b)) + Integer.parseInt(String.valueOf(carry));
    }

    public static String addBinary(String a, String b) {
        StringBuilder response = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        char carry = '0';
        while (j >= 0 || i >= 0) {
            char aChar = i < 0 ? '0' : a.charAt(i);
            char bChar = j < 0 ? '0' : b.charAt(j);
            int sum = getSum(aChar, bChar, carry);
            if (sum == 0) {
                response.append("0");
                carry = '0';
            } else if (sum == 1) {
                response.append("1");
                carry = '0';
            } else if (sum == 2) {
                response.append("0");
                carry = '1';
            } else if (sum == 3) {
                response.append("1");
                carry = '1';
            }
            j--;
            i--;
        }
        if (carry == '1') {
            response.append("1");
        }
        return response.reverse().toString();
    }

    public static String addBinaryBits(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2);
        BigInteger carry, answer;
        while (y.compareTo(zero) != 0) {
            answer = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            x = answer;
            y = carry;
        }
        return x.toString(2);
    }

    public static void main(String[] args) {
        System.out.println(addBinaryBits("11", "1"));
    }
}
