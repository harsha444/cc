package leetcode.june;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumPerformanceOfTeam {
    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        long result = 0;
        long sumHere = 0;
        int[][] es = new int[n][2];
        for (int i = 0; i < n; i++) {
            es[i] = new int[] { efficiency[i], speed[i] };
        }
        Arrays.sort(es, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int[] a : es) {
            pq.add(a[1]);
            sumHere = (sumHere + a[1]);
            if (pq.size() > k) {
                sumHere -= pq.poll();
            }
            result = Math.max(result, (sumHere * a[0]));
        }
        return (int) (result % (long) (1e9 + 7));
    }

    public static void main(String[] args) {
        System.out.println(maxPerformance(6, new int[] { 2, 10, 3, 1, 5, 8 }, new int[] { 5, 4, 3, 9, 7, 2 }, 3));
    }
}
