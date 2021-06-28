package leetcode.june;

import java.util.Arrays;
import java.util.Collections;

public class MatchSticksToSquare {
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) {
            return false;
        }
        int numsSum = Arrays.stream(nums).sum();
        if (numsSum % 4 != 0) {
            return false;
        }
        return dfs(nums, new int[4], 0, numsSum / 4);
    }

    private boolean dfs(int[] nums, int[] sums, int index, int target) {
        if (index == nums.length) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            if (sums[i] + nums[index] <= target) {
                sums[i] += nums[index];
                if (dfs(nums, sums, index + 1, target)) {
                    return true;
                }
                sums[i] -= nums[index];
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
