package facebook.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Queue<Integer> sourceList = new LinkedList<>();
        // Initialize graph
        for (int i = 0; i < vertices; i++) {
            graph.put(i, new ArrayList<>());
            inDegree.put(i, 0);
        }
        // populate graph
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0], child = edges[i][1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        // find all sources
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sourceList.add(entry.getKey());
            }
        }

        // for each source, add it to sortedList, add child to source, remove child indegree - 1
        while (!sourceList.isEmpty()) {
            int source = sourceList.poll();
            sortedOrder.add(source);
            for (int child : graph.get(source)) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    sourceList.add(child);
                }
            }
        }
        return sortedOrder;
    }
}
