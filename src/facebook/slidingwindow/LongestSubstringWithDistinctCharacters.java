package facebook.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithDistinctCharacters {
    public static int lengthOfLongestSubstring(String str) {
        int longestSubStringLen = Integer.MIN_VALUE;
        int start = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            char currChar = str.charAt(end);
            if (charIndexMap.containsKey(currChar)) {
                start = Math.max(start, charIndexMap.get(currChar) + 1);
            }
            charIndexMap.put(currChar, end);
            longestSubStringLen = Math.max(longestSubStringLen, end - start + 1);
        }
        return longestSubStringLen;
    }

    public static void main(String[] args) {

    }
}
