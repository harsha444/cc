package facebook.lc;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Pair {
    char c;

    int index;

    public Pair(char c, int index) {
        this.c = c;
        this.index = index;
    }
}

public class MinRemoveToValidParenthesis {
    public static String minRemoveToMakeValid(String s) {
        char[] c = s.toCharArray();
        Stack<Pair> stack = new Stack<>();
        StringBuilder response = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar != '(' && currChar != ')') {
                continue;
            }
            if (stack.isEmpty() || currChar == '(') {
                stack.push(new Pair(currChar, i));
                continue;
            }
            if (stack.peek().c == '(') {
                stack.pop();
            } else {
                stack.push(new Pair(currChar, i));
            }
        }
        Set<Integer> indexToBeRemoved = new HashSet<>();
        while (!stack.isEmpty()) {
            indexToBeRemoved.add(stack.peek().index);
            stack.pop();
        }
        for (int i = 0; i < c.length; i++) {
            if (indexToBeRemoved.contains(i)) {
                continue;
            }
            response.append(c[i]);
        }
        return response.toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("))(("));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
    }
}
