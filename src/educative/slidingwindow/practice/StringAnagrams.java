package educative.slidingwindow.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<>();
        int matched = 0;
        Map<Character, Integer> patternMap = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);
        }
        int start = 0;
        for (int end = 0; end < str.length(); end++) {
            char endChar = str.charAt(end);
            if (patternMap.containsKey(endChar)) {
                patternMap.put(endChar, patternMap.get(endChar) - 1);
                if (patternMap.get(endChar) == 0) {
                    matched += 1;
                }
            }
            if (matched == patternMap.size()) {
                resultIndices.add(start);
            }
            if (end >= pattern.length() - 1) {
                char startChar = str.charAt(start);
                if (patternMap.containsKey(startChar)) {
                    if (patternMap.get(startChar) == 0) {
                        matched -= 1;
                    }
                    patternMap.put(startChar, patternMap.get(startChar) + 1);
                }
                start += 1;
            }
        }
        return resultIndices;
    }

    public static void main(String[] args) {

    }
}
