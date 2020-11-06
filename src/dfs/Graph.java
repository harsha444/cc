package dfs;

import java.util.LinkedList;

public class Graph {
    private int v;

    private LinkedList<Integer>[] adj;

    Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int w) {
        adj[u].add(w);
    }

    void dfsUtil(int s, boolean[] visited) {
        visited[s] = true;
        System.out.println(s + " ");
        for (int n : adj[s]) {
            if (!visited[n]) {
                dfsUtil(n, visited);
            }
        }
    }

    void dfs(int s) {
        boolean[] visited = new boolean[v];
        dfsUtil(s, visited);
    }
}
