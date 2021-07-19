package educative.slidingwindow.practice;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    private void popFirstElement(Map<Character, Integer> m, char start) {
        m.put(start, m.get(start) - 1);
        if (m.get(start) <= 0) {
            m.remove(start);
        }
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int start = 0;
        int maxWindowSize = Integer.MIN_VALUE;
        Map<Character, Integer> m = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            char currChar = s.charAt(end);
            m.put(currChar, m.getOrDefault(currChar, 0) + 1);
            while (m.size() > k) {
                popFirstElement(m, s.charAt(start));
                start++;
            }
            maxWindowSize = Math.max(maxWindowSize, end - start + 1);
        }
        return maxWindowSize;
    }

    public static void main(String[] args) {

    }
}
