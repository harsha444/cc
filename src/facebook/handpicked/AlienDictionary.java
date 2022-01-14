package facebook.handpicked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDictionary {
    public static String findOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        // graph
        Map<Character, List<Character>> graph = new HashMap<>();
        // indegree
        Map<Character, Integer> indegree = new HashMap<>();
        for (String s : words) {
            for (char c : s.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
                indegree.put(c, 0);
            }
        }
        //initialize graph
        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String nextString = words[i + 1];
            for (int j = 0; j < Math.min(curr.length(), nextString.length()); j++) {
                char parent = curr.charAt(j);
                char child = curr.charAt(j);
                if(parent!=child) {
                    indegree.put(child, indegree.getOrDefault(child, 0)+1);
                    graph.get(parent).add(child);
                    break;
                }
            }
        }
        //sources queue
        Queue<Character> queue = new LinkedList<>();
        //add sources queue
        StringBuilder response = new StringBuilder();
        return response.toString();
    }

    public static void main(String[] args) {

    }
}
