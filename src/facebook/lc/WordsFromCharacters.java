package facebook.lc;

import java.util.HashMap;
import java.util.Map;

public class WordsFromCharacters {
    private boolean checkSubSet(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        for (Map.Entry<Character, Integer> e : m1.entrySet()) {
            Character key = e.getKey();
            if (!m2.containsKey(key) || m2.get(key) < m1.get(key)) {
                return false;
            }
        }
        return true;
    }

    public int countCharacters(String[] words, String chars) {
        int response = 0;
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            m.put(chars.charAt(i), m.getOrDefault(chars.charAt(i), 0) + 1);
        }
        for (String s : words) {
            Map<Character, Integer> charMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                charMap.put(c, charMap.getOrDefault(c, 0) + 1);
            }
            if (checkSubSet(charMap, m)) {
                response += s.length();
            }
        }
        return response;
    }
}
