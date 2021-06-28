package fb;

import java.util.*;

public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] arr = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = arr[i + j + 1] + product;
                arr[i + j + 1] = sum % 10;
                arr[i + j] += sum / 10;
            }
        }
        StringBuilder s = new StringBuilder();
        for(int p: arr) {
            if(!(s.length()==0 && p==0)) {
                s.append(p);
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("12", "12"));
    }
}