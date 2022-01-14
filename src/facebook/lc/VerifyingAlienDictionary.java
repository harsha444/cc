package facebook.lc;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAlienDictionary {
    private static boolean isSorted(Map<Character, Integer> m, String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (m.get(s2.charAt(i)) > m.get(s1.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            m.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            if (!isSorted(m, words[i], words[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[] { "hello", "hello" }, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(isAlienSorted(new String[] { "word", "world", "row" }, "worldabcefghijkmnpqstuvxyz"));
    }
}
