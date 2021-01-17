package google.hashmap;

import java.util.*;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return String.valueOf(sChar).equals(String.valueOf(tChar));
    }

    public static boolean isAnagramHashMap(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int[] m = new int[26];
        for(int i=0; i<sChar.length; i++) {
            m[sChar[i]-'a'] += 1;
            m[tChar[i]-'a'] -= 1;
        }
        for(int i=0; i<26; i++) {
            if(m[i]!=0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "nan";
        String b = "ann";
        System.out.println(isAnagramHashMap(a, b));
    }
}
