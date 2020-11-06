package graphs.BFS;

import java.util.LinkedList;

public class Graph {
    private int v;
    private LinkedList<Integer>[] adj;

    Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; ++i) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void bfs(int s){
        boolean[] visited = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<> ();
        visited[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            s = queue.poll();
            System.out.println(s + " ");
            for (int i : adj[s]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    void printGraph() {
        for(int i=0; i<v; i++) {
            for(int j=0; j<adj[i].size(); j++) {
                System.out.println(adj[i].get(j));
            }
            System.out.println("---");
        }
    }
}
