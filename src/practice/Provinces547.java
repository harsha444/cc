package practice;

import java.util.HashSet;
import java.util.Set;
import templates.DisjointUnionSet;

public class Provinces547 {
    public int findCircleNum(int[][] isConnected) {
        DisjointUnionSet du = new DisjointUnionSet(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    du.union(i, j);
                }
            }
        }
        Set<Integer> s = new HashSet<>();
        for (int i=0; i<isConnected.length; i++) {
            s.add(du.find(i));
        }
        return s.size();
    }

    public static void main(String[] args) {

    }
}
