package fb.arrays;

import java.util.Stack;

public class MaxNestingDepth {
    public static int maxDepth(String s) {
        int maxDepth = Integer.MIN_VALUE;
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int currSum = 0;
        for (char c : charArray) {
            if (c == '(') {
                currSum += 1;
                maxDepth = Math.max(currSum, maxDepth);
            } else if (c == ')') {
                currSum -= 1;
            }
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
    }
}
