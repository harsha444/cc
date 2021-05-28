package google.dp;

import java.util.Arrays;

public class SubSetSum {
    public static boolean subsetIsPossible(int[] arr, int target) {
        int len = arr.length;
        boolean[] dp = new boolean[target + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 0; i < len; i++) {
            for (int j = target; j >= 1; j--) {
                if (j >= arr[i]) {
                    dp[j] = dp[j] || dp[j - arr[i]];
                }
            }
        }
        return dp[target];
    }

    public static boolean canPartition(int[] nums) {
        if(nums.length<4) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if(sum%4 != 0) {
            return false;
        } else {
            return subsetIsPossible(nums, sum/4);
        }
    }

    public static void main(String[] args) {
        subsetIsPossible(new int[] { 2, 3, 5 }, 10);
    }
}
