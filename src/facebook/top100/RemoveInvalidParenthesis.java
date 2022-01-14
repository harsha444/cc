package facebook.top100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParenthesis {
    public List<String> removeInvalidParentheses(String s) {
        List<String> response = new ArrayList<>();
        if (s == null) {
            return response;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        boolean found = false;
        while (!queue.isEmpty()) {
            String currString = queue.poll();
            if (isValid(currString)) {
                response.add(currString);
                found = true;
            }
            if (!found) {
                for (int i = 0; i < currString.length(); i++) {
                    if (currString.charAt(i) != '(' && currString.charAt(i) != ')') {
                        continue;
                    }
                    String subString = currString.substring(0, i) + currString.substring(i + 1);
                    if (!visited.contains(subString)) {
                        queue.add(subString);
                        visited.add(subString);
                    }
                }
            }

        }
        return response;
    }

    private boolean isValid(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                res++;
            } else if (s.charAt(i) == ')'){
                res--;
            }
            if (res < 0) {
                return false;
            }
        }
        return res == 0;
    }

    public static void main(String[] args) {

    }
}
