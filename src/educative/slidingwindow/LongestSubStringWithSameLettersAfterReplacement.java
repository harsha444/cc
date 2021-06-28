package educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithSameLettersAfterReplacement {
    public static int findLength(String str, int k) {
        int maxLen = Integer.MIN_VALUE;
        int start = 0;
        int maxFrequencyInAWindow = 0;
        Map<Character, Integer> m = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            char currChar = str.charAt(end);
            m.put(currChar, m.getOrDefault(currChar, 0) + 1);
            maxFrequencyInAWindow = Math.max(maxFrequencyInAWindow, m.get(currChar));
            if (end - start + 1 - maxFrequencyInAWindow > k) {
                char windowStartChar = str.charAt(start);
                m.put(windowStartChar, m.get(windowStartChar) - 1);
                start++;
            }
            maxLen = Math.max(end - start + 1, maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {

    }
}
