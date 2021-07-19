package fb.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PrintAllPaths {
    static class Edge {
        public int src;

        public int neighbour;

        public int weight;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.neighbour = nbr;
            this.weight = wt;
        }
    }

    private static boolean printPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String res) {
        if (src == dest) {
            System.out.println(res + dest);
            return true;
        }
        visited[src] = true;
        for (Edge edge : graph[src]) {
            if (!visited[edge.neighbour]) {
                printPaths(graph, edge.neighbour, dest, visited, res + edge.neighbour);
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());
        printPaths(graph, src, dest, new boolean[vtces], "");
    }
}
