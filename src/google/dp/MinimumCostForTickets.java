package google.dp;

import java.util.HashSet;
import java.util.Set;

public class MinimumCostForTickets {
    public static int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        dp[0] = 0;
        Set<Integer> s = new HashSet<>();
        for (int day : days) {
            s.add(day);
        }
        for (int j = 1; j <= lastDay; j++) {
            if (!s.contains(j)) {
                dp[j] = dp[j - 1];
                continue;
            }
            dp[j] = dp[j - 1] + costs[0];
            dp[j] = Math.min(dp[j], dp[Math.max(j - 7, 0)] + costs[1]);
            dp[j] = Math.min(dp[j], dp[Math.max(j - 30, 0)] + costs[2]);
        }
        return dp[lastDay];
    }

    public static void main(String[] args) {
        mincostTickets(new int[] { 1, 4, 6, 7, 8, 20 }, new int[] { 2, 7, 15 });
    }
}
