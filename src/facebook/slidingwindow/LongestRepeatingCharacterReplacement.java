package facebook.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String str, int k) {
        int maxLen = Integer.MIN_VALUE;
        int maxFrequencyLetterInaWindow = Integer.MIN_VALUE;
        int start = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            char currChar = str.charAt(end);
            charFrequencyMap.put(currChar, charFrequencyMap.getOrDefault(currChar, 0) + 1);
            maxFrequencyLetterInaWindow = Math.max(maxFrequencyLetterInaWindow, charFrequencyMap.get(currChar));
            if (end - start + 1 - maxFrequencyLetterInaWindow > k) {
                char startChar = str.charAt(start);
                charFrequencyMap.put(startChar, charFrequencyMap.get(startChar) - 1);
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {

    }
}
