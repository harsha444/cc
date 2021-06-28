package educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {
    private static void popElements(Map<Character, Integer> m, char[] arr, int start) {
        if (m.containsKey(arr[start])) {
            m.put(arr[start], m.get(arr[start]) - 1);
        }
        if (m.get(arr[start]) == 0) {
            m.remove(arr[start]);
        }
    }

    public static int findLength(char[] arr) {
        int maxLen = Integer.MIN_VALUE;
        int start = 0;
        Map<Character, Integer> m = new HashMap<>();
        for (int end = 0; end < arr.length; end++) {
            char currChar = arr[end];
            m.put(currChar, m.getOrDefault(currChar, 0) + 1);
            while (m.size() > 2) {
                popElements(m, arr, start);
                start += 1;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {

    }
}
