package educative.slidingwindow.practice;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {
    private boolean check() {
        return true;
    }

    public static boolean findPermutation(String str, String pattern) {
        Map<Character, Integer> patternFreqMap = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            patternFreqMap.put(c, patternFreqMap.getOrDefault(c, 0) + 1);
        }
        int patternLen = pattern.length();
        int stringLen = str.length();
        int start = 0;
        for (int end = 0; end < str.length(); end++) {
            int currChar = str.charAt(end);

        }
        return false;
    }

    public static void main(String[] args) {

    }
}
