package leetcode.june;

public class MinRefuelingStops {
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        long[] dp = new long[n + 1];
        dp[0] = startFuel;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (dp[j] >= stations[i][0]) {
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + (long) stations[i][1]);
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(minRefuelStops(100, 10, new int[][] { { 10, 60 }, { 20, 30 }, { 30, 30 }, { 60, 40 } }));
    }
}
