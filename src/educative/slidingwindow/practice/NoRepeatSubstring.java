package educative.slidingwindow.practice;

import java.util.HashMap;
import java.util.Map;

/*
* abbaab
* */
public class NoRepeatSubstring {
    public static int lengthOfLongestSubstring(String str) {
        int start = 0;
        int windowLen = Integer.MIN_VALUE;
        Map<Character, Integer> indexMap = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            char currChar = str.charAt(end);
            if (indexMap.containsKey(currChar)) {
                start = Math.max(start, indexMap.get(currChar)+1);
            }
            indexMap.put(currChar, end);
            windowLen = Math.max(windowLen, end - start + 1);
        }
        return windowLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
