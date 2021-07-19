package educative.slidingwindow.practice;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {
    public static int findLength(String str, int k) {
        int start = 0;
        int maxRepeatLetterCount = 0;
        int maxLen = 0;
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            char currChar = str.charAt(end);
            charFrequency.put(currChar, charFrequency.getOrDefault(currChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, charFrequency.get(currChar));
            if (end - start + 1 - maxRepeatLetterCount > k) {
                char startChar = str.charAt(start);
                charFrequency.put(startChar, charFrequency.get(startChar) - 1);
                start += 1;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {

    }
}
