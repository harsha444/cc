package educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacters {
    public static int findLength(String str) {
        int n = str.length();
        int maxLen = 0;
        int start = 0;
        Map<Character, Integer> m = new HashMap<>();
        for (int end = 0; end < n; end++) {
            char currChar = str.charAt(end);
            if (m.containsKey(currChar)) {
                start = m.get(currChar) + 1;
            }
            m.put(currChar, end);
            maxLen = Math.max(end - start + 1, maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {

    }
}
