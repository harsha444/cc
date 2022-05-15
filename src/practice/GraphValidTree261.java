package practice;

import java.util.HashSet;
import java.util.Set;

class DisjointUnionSet {
    int[] set;

    int[] rank;

    int size;

    public DisjointUnionSet(int n) {
        size = n;
        set = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            set[i] = i;
            rank[i] = 1;
        }
    }

    public void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA != parentB) {
            if (rank[parentA] > rank[parentB]) {
                set[parentB] = parentA;
            } else if (rank[parentB] > rank[parentA]) {
                set[parentA] = parentB;
            } else {
                set[parentA] = parentB;
                rank[parentB] += 1;
            }
        }
    }

    public int find(int n) {
        while (n != set[n]) {
            n = set[set[n]];
        }
        return n;
    }
}

public class GraphValidTree261 {
    public boolean validTree(int n, int[][] edges) {
        DisjointUnionSet du = new DisjointUnionSet(n);
        Set<Integer> set = new HashSet<>();
        for (int[] i : edges) {
            if (du.find(i[0]) == du.find(i[1])) {
                return false;
            }
            du.union(i[0], i[1]);
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
