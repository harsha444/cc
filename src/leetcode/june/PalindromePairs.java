package leetcode.june;

import java.util.*;

public class PalindromePairs {
    public List<List<Integer>> palindromePairsBruteForce(String[] words) {
        List<List<Integer>> resp = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }
                String combined = words[i].concat(words[j]);
                String reversed = new StringBuilder(combined).reverse().toString();
                if (combined.equals(reversed)) {
                    resp.add(Arrays.asList(i, j));
                }
            }
        }
        return resp;
    }

    private boolean isPalindrome(String s, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            if (s.charAt(startIndex) != s.charAt(endIndex)) {
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }

    private List<String> allValidPrefixes(String word) {
        List<String> validPrefixes = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (isPalindrome(word, i, word.length() - 1)) {
                validPrefixes.add(word.substring(0, i));
            }
        }
        return validPrefixes;
    }

    private List<String> allValidSuffixes(String word) {
        List<String> validSuffixes = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (isPalindrome(word, 0, i)) {
                validSuffixes.add(word.substring(i + 1, word.length()));
            }
        }
        return validSuffixes;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> wordsIndexMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordsIndexMap.put(words[i], i);
        }

        List<List<Integer>> response = new ArrayList<>();

        for (String s : words) {
            int currIndex = wordsIndexMap.get(s);
            String reversed = new StringBuilder(s).reverse().toString();
            if (wordsIndexMap.containsKey(reversed) && wordsIndexMap.get(reversed) != currIndex) {
                response.add(Arrays.asList(currIndex, wordsIndexMap.get(reversed)));
            }

            for (String suffix : allValidSuffixes(s)) {
                String reversedSuffix = new StringBuilder(suffix).reverse().toString();
                if (wordsIndexMap.containsKey(reversedSuffix)) {
                    response.add(Arrays.asList(wordsIndexMap.get(reversedSuffix), currIndex));
                }
            }

            for (String prefix : allValidPrefixes(s)) {
                String reversedPrefix = new StringBuilder(prefix).reverse().toString();
                if (wordsIndexMap.containsKey(reversedPrefix)) {
                    response.add(Arrays.asList(currIndex, wordsIndexMap.get(reversedPrefix)));
                }
            }

        }
        return response;
    }

    public static void main(String[] args) {

    }
}
