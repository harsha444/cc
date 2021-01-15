package google.graphs;

import java.util.*;

public class DisjointSet {
	public static void initialize(int[] arr, int[] w) {
		for(int i=0; i<arr.length; i++) {
			w[i] = 1;
			arr[i] = i;
		}
	}

	public static int root(int i, int[] arr) {
		while(arr[i]!=i) {
			i = arr[arr[i]];
		}
		return i;
	}

	public static boolean find(int a, int b, int[] arr) {
		int rootA = root(a, arr);
		int rootB = root(b, arr);
		return rootA == rootB;
	}

	public static void union(int[] arr, int[] w, int a, int b) {
		int aRoot = root(a, arr);
		int bRoot = root(b, arr);
		if(w[aRoot] > w[bRoot]) {
			w[aRoot] += w[bRoot];
			arr[bRoot] = arr[aRoot];
		} else {
			w[bRoot] += w[aRoot];
			arr[aRoot] = arr[bRoot];
		}
	}

	public static void main(String[] args) {
		int[] a = new int[6];
		int[] w = new int[6];
		initialize(a, w);
		union(a,w,1,2);
		System.out.println(find(1,2, a));
		System.out.println(find(1,3, a));
	}
}