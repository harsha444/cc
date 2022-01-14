package facebook.top100;

import java.util.*;

public class VerifyAlienDictionary {
    private static boolean isSorted(Map<Character, Integer> map, String curr, String next) {
        int currLen = curr.length();
        int nextLen = next.length();
        for (int i = 0; i < Math.min(currLen, nextLen); i++) {
            if (curr.charAt(i) != next.charAt(i)) {
                if (map.get(next.charAt(i)) > map.get(curr.charAt(i))) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return nextLen >= currLen;
    }

    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderMap = new HashMap<>();
        int len = order.length();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), len - i - 1);
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(orderMap, words[i], words[i + 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[] { "hello", "leetcode" }, "hlabcdefgijkmnopqrstuvwxyz"));
    }
}
