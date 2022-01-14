package facebook.top100;

import java.util.Stack;

public class BasicCalculatorII {
    public static int calculate(String s) {
        int response = 0;
        char operator = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                response = response * 10 + (s.charAt(i) - '0');
            }
            if ((!Character.isDigit(s.charAt(i)) &&!Character.isSpaceChar(s.charAt(i))) || i==s.length()-1) {
                if (operator == '+') {
                    stack.push(response);
                } else if (operator == '-') {
                    stack.push(-response);
                } else if (operator == '*') {
                    stack.push(stack.pop() * response);
                } else if (operator == '/') {
                    stack.push(stack.pop() / response);
                }
                operator = s.charAt(i);
                response = 0;
            }
        }
        int r = 0;
        for (int i : stack) {
            r += i;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(calculate("12+2/2"));
    }
}
