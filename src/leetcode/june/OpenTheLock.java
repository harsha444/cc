package leetcode.june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {
    private List<String> neighbours(String curr) {
        List<String> result = new ArrayList<>();
        for(int i=0; i<4; i++) {
            int x = curr.charAt(i) - '0';
            for (int diff = -1; diff <= 1; diff += 2) {
                int y = (x + diff + 10) % 10;
                result.add(curr.substring(0, i) + ("" + y) + curr.substring(i + 1));
            }
        }
        return result;
    }

    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains("0000")) {
            return -1;
        }
        Queue<String> q = new LinkedList<>(Arrays.asList("0000"));
        for (int steps = 0; !q.isEmpty(); steps++) {
            for (int i = q.size(); i > 0; --i) {
                String curr = q.poll();
                if (curr.equals(target)) {
                    return steps;
                }
                for(String nei: neighbours(curr)) {
                    if(deadSet.contains(nei)) {
                        continue;
                    }
                    deadSet.add(nei);
                    q.offer(nei);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
