package fb;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * https://leetcode.com/problems/sliding-window-maximum/
 * */
public class SlidingWindowMaximum {
    public static int getMaxInWindow(Queue<int[]> pq, int s) {
        while (pq.peek()[1] < s) {
            pq.poll();
        }
        return pq.peek()[0];
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] maxArray = new int[n - k + 1];
        int s = 0;
        for (int e = 0; e < n; e++) {
            pq.offer(new int[] { nums[e], e });
            if (e >= k - 1) {
                maxArray[e - k + 1] = getMaxInWindow(pq, s);
                s++;
            }
        }
        return maxArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 9, 11 }, 2)));
    }
}
