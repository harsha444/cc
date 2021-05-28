package google.dp;

/*
 * X-0-1-2-3-4-5-6-7-8-9-10-11
 * 1-0-1-2-3-4-5-6-7-8-9-10-11
 * 2-0-1-1-
 * 5-0-
 * */
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = i;
        }
        for (int j = 1; j <= amount; j++) {
            for (int i = 0; i < coins.length; i++) {
                if (coins[i] <= j) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]]) + 1;
                }
            }
        }
        return dp[amount + 1];
    }

    public static void main(String[] args) {

    }
}
