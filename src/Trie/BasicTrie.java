package Trie;

import java.util.LinkedList;
import java.util.List;

public class BasicTrie {
    static final int ALPHABET_SIZE = 26;

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        boolean isEndOfTheWord;

        TrieNode() {
            isEndOfTheWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }
    }

    static TrieNode root;

    static void insert(String key) {
        TrieNode pCrawl = root;
        for (int level = 0; level < key.length(); level++) {
            int index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null) {
                pCrawl.children[index] = new TrieNode();
            }
            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfTheWord = true;
    }

    static boolean search(String key) {
        TrieNode pCrawl = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (pCrawl.children[index] == null) {
                return false;
            }
            pCrawl = pCrawl.children[index];
        }
        return (pCrawl != null && pCrawl.isEndOfTheWord);
    }

    static List<String> autoComplete(List<String> resp, TrieNode pCrawl, String prefix) {
        boolean isEndOfWord = pCrawl.isEndOfTheWord;
        if (isEndOfWord) {
            resp.add(prefix);
        }
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (pCrawl.children[i] != null) {
                autoComplete(resp, pCrawl.children[i], prefix + (char) (i+97));
            }
        }
        return resp;
    }

    static List<String> autoCompleteUtil(String key) {
        LinkedList<String> resp = new LinkedList<>();
        TrieNode pCrawl = root;
        for (char c : key.toCharArray()) {
            int index = c - 'a';
            if (pCrawl.children[index] == null) {
                return resp;
            }
            pCrawl = pCrawl.children[index];
        }

        autoComplete(resp, pCrawl, key);
        return resp;
    }

    public static void main(String[] args) {
        String[] keys = { "the", "a", "there", "answer", "any", "by", "bye", "their" };
        root = new TrieNode();
        for (String key : keys) {
            insert(key);
        }
        System.out.println(search("the"));
        System.out.println(search("asda"));
        System.out.println(search("any"));
        System.out.println(autoCompleteUtil("a"));
    }
}
