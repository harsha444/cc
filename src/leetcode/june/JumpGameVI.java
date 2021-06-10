package leetcode.june;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 *
 *
 *  */
public class JumpGameVI {
    public static int maxResultLinear(int[] nums, int k) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        //        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 1; i < nums.length; i++) {
            for (int j = Math.max(0, i - k); j < i; j++) {
                dp[i] = Math.max(dp[j] + nums[i], dp[i]);
            }
        }
        return dp[nums.length - 1];
    }

    public static int maxResult(int[] nums, int k) {
        int result = nums[0];
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.offer(new int[] { nums[0], 0 });
        for (int i = 1; i < nums.length; i++) {
            while (pq.peek()[1] < i - k) {
                pq.poll();
            }
            int[] curr = pq.peek();
            result = curr[0] + nums[i];
            pq.offer(new int[] { result, i });
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxResult(new int[] { 1,-5,-20,4,-1,3,-6,-3 }, 2));
    }
}
