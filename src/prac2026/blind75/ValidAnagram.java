package prac2026.blind75;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];
        if(s==null && t==null){
            return true;
        }
        if(s==null || t==null) {
            return false;
        }
        if(s.length() != t.length()) {
            return false;
        }
        int len = s.length();
        for(int i=0; i<len; i++) {
            map[s.charAt(i)-'a']++;
        }

        for(int i=0; i<len; i++) {
            map[t.charAt(i)-'a']--;
        }

        for(int i=0; i<26; i++){
            if(map[i]!=0) {
                return false;
            }
        }
        return true;
    }
}
