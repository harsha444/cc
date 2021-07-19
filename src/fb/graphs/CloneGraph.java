package fb.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
    Map<Node, Node> m = new HashMap<>();

    public Node cloneGraph(Node node) {
        dfs(node);
        return node;
    }

    private Node dfs(Node node) {
        if (node == null) {
            return null;
        }
        if (m.containsKey(node)) {
            return m.get(node);
        }
        Node cloneNode = new Node(node.val, new ArrayList<>());
        m.put(node, cloneNode);
        for (Node neighbour : node.neighbors) {
            node.neighbors.add(dfs(neighbour));
        }
        return cloneNode;
    }
}
