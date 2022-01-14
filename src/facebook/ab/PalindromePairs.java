//package airbnb;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class PalindromePairs {
//    public List<List<Integer>> palindromePairs(String[] words) {
//        List<List<Integer>> response = new ArrayList<>();
//        Map<String, Integer> wordsIndexMap = new HashMap<>();
//        for (int i = 0; i < words.length; i++) {
//            wordsIndexMap.put(words[i], i);
//        }
//        for (String s : words) {
//            String reversed = new StringBuilder(s).reverse().toString();
//            if(wordsIndexMap.containsKey(reversed)) {
//                response.add(Arrays.asList(words[]));
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
