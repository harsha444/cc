package google.graphs;

import java.util.*;

public class OwlFight {
	public static void initialize(int[] arr) {
		for(int i=0; i<arr.length; i++) {
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

	public static void union(int[] arr, int a, int b) {
		int aRoot = root(a, arr);
		int bRoot = root(b, arr);
		if(aRoot > bRoot) {
			arr[bRoot] = arr[aRoot];
		} else {
			arr[aRoot] = arr[bRoot];
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] a = new int[N];
		initialize(a);
		for(int i=0; i<M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			union(a, u-1, v-1);
		}
		int q = sc.nextInt();
		for(int i=0; i<q; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			if(find(u-1, v-1, a)) {
				System.out.println("TIE");
			} else if(root(u-1, a)>root(v-1, a)) {
				System.out.println(u);
			} else {
				System.out.println(v);
			}
		}
	}
}