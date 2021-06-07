package fb;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        char[] c = s.toCharArray();
        int i = 0;
        Map<Character, Integer> m = new HashMap<>();
        for (int j = 0; j < n; j++) {
            if (m.containsKey(c[j]) && m.get(c[j]) >= i) {
                i = m.get(c[j]) + 1;
            }
            res = Math.max(res, j - i + 1);
            m.put(c[j], j);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
