package leetcode.june;

public class StoneGameVII {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[][] dp = new int[n][n];
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i - 1];
        }
        for (int len = 2; len <= n; len++) {
            for (int start = 0; start + len - 1 < n; start++) {
                int end = start + len - 1;
                int scoreRemoveFirst = prefixSum[end + 1] - prefixSum[start + 1];
                int scoreRemoveLast = prefixSum[end] - prefixSum[start];
                dp[start][end] = Math.max(scoreRemoveFirst - dp[start + 1][end], scoreRemoveLast - dp[start][end - 1]);
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {

    }
}
