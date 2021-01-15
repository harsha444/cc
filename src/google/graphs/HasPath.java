package google.graphs;

import java.util.*;
import java.io.*;


public class HasPath {
   static class Edge {
		int source;
		int neighbour;
		int weight;
		Edge(int source, int neighbour, int weight) {
			this.source = source;
			this.neighbour = neighbour;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int vtcs = Integer.parseInt(br.readLine());
		ArrayList<Edge>[] g = new ArrayList[vtcs];
		for(int i=0; i<vtcs; i++) {
			g[i] = new ArrayList<>();
		}
		int edges = Integer.parseInt(br.readLine());
		for(int i=0; i<edges; i++) {
			String[] line = br.readLine().split(" ");
			int v1 = Integer.parseInt(line[0]);
			int v2 = Integer.parseInt(line[1]);
			int wt = Integer.parseInt(line[2]);
			g[v1].add(new Edge(v1, v2, wt));
			g[v2].add(new Edge(v2, v1, wt));
		}
		int src = Integer.parseInt(br.readLine());
		int dest = Integer.parseInt(br.readLine());
		System.out.println(hasPath(g, src, dest, new boolean[vtcs]));
	}

	public static Boolean hasPath(ArrayList<Edge>[] g, int src, int dest, boolean[] visited) {
		if(src == dest) {
			return true;
		}
		visited[src] = true;
		for(Edge li: g[src]) {
			if(visited[li.neighbour] == false) {
				if(hasPath(g, li.neighbour, dest, visited)) {
				return true;
				}
			}
		}
		return false;
	}
}