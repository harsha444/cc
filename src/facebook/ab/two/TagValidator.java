package facebook.ab.two;

import java.util.Stack;

public class TagValidator {
    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < code.length()) {
            if(i>0 && stack.isEmpty()) return false;

        }
        return stack.isEmpty();
    }
}
