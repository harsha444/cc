package facebook.lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    public int val;

    public List<Node> neighbors;

    public Node() {
        this.val = 0;
        this.neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }

    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}

public class CloneGraph {
    Map<Node, Node> nodeCloneNodeMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (nodeCloneNodeMap.containsKey(node)) {
            // Returning clone node
            return nodeCloneNodeMap.get(node);
        }
        Node cloneNode = new Node(node.val, new ArrayList<>());
        nodeCloneNodeMap.put(node, cloneNode);
        for (Node neighbour : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbour));
        }
        return cloneNode;
    }

    public static void main(String[] args) {

    }
}
