package facebook.ab.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {
    private boolean isPalindrome(String str, int s, int e) {
        while (s < e) {
            if (str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }

    private List<String> getAllValidSuffixes(String s) {
        List<String> validSuffix = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, 0, i)) {
                validSuffix.add(s.substring(i + 1));
            }
        }
        return validSuffix;
    }

    private List<String> getAllValidPrefixes(String s) {
        List<String> validPrefixes = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i, s.length() - 1)) {
                validPrefixes.add(s.substring(0, i));
            }
        }
        return validPrefixes;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> response = new ArrayList<>();
        Map<String, Integer> wordsIndexMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordsIndexMap.put(words[i], i);
        }

        for (String s : words) {
            int index = wordsIndexMap.get(s);
            String reversed = new StringBuilder(s).reverse().toString();
            if (wordsIndexMap.containsKey(reversed) && wordsIndexMap.get(reversed) != index) {
                response.add(Arrays.asList(index, wordsIndexMap.get(reversed)));
            }

            for (String suffix : getAllValidSuffixes(s)) {
                String reversedSuffix = new StringBuilder(suffix).reverse().toString();
                if (wordsIndexMap.containsKey(reversedSuffix)) {
                    response.add(Arrays.asList(index, wordsIndexMap.get(reversedSuffix)));
                }
            }

            for (String suffix : getAllValidPrefixes(s)) {
                String reversedPrefix = new StringBuilder(suffix).reverse().toString();
                if (wordsIndexMap.containsKey(reversedPrefix)) {
                    response.add(Arrays.asList(index, wordsIndexMap.get(reversedPrefix)));
                }
            }
        }
        return response;
    }
}