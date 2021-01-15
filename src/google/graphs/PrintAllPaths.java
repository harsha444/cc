package google.graphs;

import java.util.*;
import java.io.*;

class Edge {
	int start;
	int end;
	int w;

	Edge(int start, int end, int w) {
		this.start = start;
		this.end = end;
		this.w = w;
	}
}

public class PrintAllPaths {

	static ArrayList<Integer>[] pathsArray;

	public static void printPaths(ArrayList<Edge>[] g, int src, int dest, int[] visited, String res) {
		visited[src] = 1;
		for(Edge e: g[src]) {
			if(visited[e.end]!=1) {
				res+=e.end;
				printPaths(g, e.end, dest, visited, res);
			}
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int v = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());
		ArrayList<Edge>[] g = new ArrayList[v];
		pathsArray = new ArrayList[v];
		for(int i=0; i<v; i++) {
			g[i] = new ArrayList<>();
		}
		for (int i=0; i<e; i++) {
			String[] line = br.readLine().split(" ");
			int s = Integer.parseInt(line[0]);
			int d = Integer.parseInt(line[1]);
			int w = Integer.parseInt(line[2]);
			g[s].add(new Edge(s, d, w));
			g[d].add(new Edge(d, s, w));
		}
		int src = Integer.parseInt(br.readLine());
		int dest = Integer.parseInt(br.readLine());
		int[] visited = new int[v];
		printPaths(g, src, dest, visited, src + "");
	}
}