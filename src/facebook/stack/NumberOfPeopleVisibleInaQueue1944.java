package facebook.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NumberOfPeopleVisibleInaQueue1944 {
    public int[] canSeePersonsCount(int[] heights) {
        int[] response = new int[heights.length];
        Map<Integer, Integer> indexValueMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && indexValueMap.get(stack.peek()) > heights[i]) {
                int top = stack.pop();
                indexValueMap.put(top, indexValueMap.getOrDefault(top, 0) + 1);
            }
        }
        return response;
    }

    public static void main(String[] args) {

    }
}
