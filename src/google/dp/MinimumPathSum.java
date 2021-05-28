package google.dp;

public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] dp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[r - 1][c - 1];
    }

    public static void main(String[] args) {
        minPathSum(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } });
    }
}
