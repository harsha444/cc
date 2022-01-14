package facebook.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    private static void popFirst(int start, String str, Map<Character, Integer> m) {
        char startChar = str.charAt(start);
        if (m.get(startChar) > 1) {
            m.put(startChar, m.get(startChar) - 1);
            return;
        }
        m.remove(startChar);
    }

    public static int findLength(String str, int k) {
        int longestSubString = Integer.MIN_VALUE;
        int windowStart = 0;
        Map<Character, Integer> characterFrequencyMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char currChar = str.charAt(windowEnd);
            characterFrequencyMap.put(currChar, characterFrequencyMap.getOrDefault(currChar, 0) + 1);
            while (characterFrequencyMap.size() > k) {
                popFirst(windowStart, str, characterFrequencyMap);
                windowStart += 1;
            }
            longestSubString = Math.max(longestSubString, windowEnd - windowStart + 1);
        }
        return longestSubString;
    }
}
