package fb.graphs;

import java.util.*;
import java.io.*;

public class HasPath {
    static class Edge {
        public int weight;

        public int src;

        public int neighbour;

        Edge(int weight, int src, int neighbour) {
            this.weight = weight;
            this.src = src;
            this.neighbour = neighbour;
        }
    }

    private static boolean hasPath(ArrayList<Edge>[] graph, int source, int dest, boolean[] visited) {
        if (source == dest) {
            return true;
        }
        visited[source] = true;
        for (Edge edge : graph[source]) {
            if (!visited[dest]) {
                return hasPath(graph, edge.neighbour, dest, visited);
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }
        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] line = br.readLine().split(" ");
            int v1 = Integer.parseInt(line[0]);
            int v2 = Integer.parseInt(line[1]);
            int wt = Integer.parseInt(line[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }
        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());
        System.out.println(hasPath(graph, src, dest, new boolean[vertices]));
    }
}
