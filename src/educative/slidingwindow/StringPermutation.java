package educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {
    public static boolean checkInclusion(String s1, String s2) {
        int windowStart = 0;
        int matched = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char c : s2.toCharArray()) {
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
        }

        for (int windowEnd = 0; windowEnd < s1.length(); windowEnd++) {
            char rightChar = s1.charAt(windowEnd);
            if (charFrequencyMap.containsKey(rightChar)) {
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) == 0) {
                    matched++;
                }
            }
            if (matched == charFrequencyMap.size()) {
                return true;
            }

            if (windowEnd >= s2.length() - 1) {
                char leftChar = s1.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0) {
                        matched--;
                    }
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
