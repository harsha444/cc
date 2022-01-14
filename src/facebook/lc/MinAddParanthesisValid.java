package facebook.lc;

import java.util.Stack;

public class MinAddParanthesisValid {
    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty() || stack.peek() == ')') {
                stack.push(c);
                continue;
            }
            if (!stack.isEmpty() && (stack.peek() == '(')) {
                stack.pop();
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("(()("));
    }
}
