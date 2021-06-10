package educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKDistinctCharacters {
    private static void popFirst(String str, Map<Character, Integer> m, int start) {
        char firstChar = str.charAt(start);
        if (m.get(firstChar) > 0) {
            m.put(firstChar, m.get(firstChar) - 1);
        }
        if (m.get(firstChar) == 0) {
            m.remove(firstChar);
        }
    }

    public static int findLength(String s, int k) {
        int n = s.length();
        int maxLen = Integer.MIN_VALUE;
        int start = 0;
        Map<Character, Integer> m = new HashMap<>();
        for (int end = 0; end < n; end++) {
            char currChar = s.charAt(end);
            m.put(currChar, m.getOrDefault(currChar, 0) + 1);
            while (m.size() > k) {
                popFirst(s, m, start);
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {

    }
}
