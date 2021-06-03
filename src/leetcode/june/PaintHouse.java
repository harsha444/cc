package leetcode.june;

import java.util.Arrays;

public class PaintHouse {
    public static int minCost(int[][] costs) {
        if (costs.length == 0 || costs == null) {
            return 0;
        }
        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        return Arrays.stream(costs[costs.length - 1]).min().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(minCost(new int[][] { { 3, 5, 3 }, { 6, 17, 6 }, { 7, 13, 18 }, { 9, 10, 18 } }));
    }
}
