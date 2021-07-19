package fb.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    private String getHash(String str) {
        int[] hashArr = new int[26];
        Arrays.fill(hashArr, 0);
        for (char c : str.toCharArray()) {
            hashArr[c - 'a'] += 1;
        }
        StringBuilder delimStr = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            delimStr.append('#');
            delimStr.append(hashArr[i]);
        }
        return delimStr.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        for (String inputString : strs) {
            String hash = getHash(inputString);
            if (!m.containsKey(hash)) {
                m.put(hash, new ArrayList<>());
            }
            List<String> curr = m.get(hash);
            curr.add(inputString);
            m.put(hash, curr);
        }
        return new ArrayList<>(m.values());
    }

    public static void main(String[] args) {

    }
}
