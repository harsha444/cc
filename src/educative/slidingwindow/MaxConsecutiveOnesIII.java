package educative.slidingwindow;

import java.util.*;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int maxLen = Integer.MIN_VALUE;
        int maxOnesInAWindow = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 1) {
                maxOnesInAWindow += 1;
            }
            if (end - start + 1 - maxOnesInAWindow > k) {
                if (nums[start] == 1) {
                    maxOnesInAWindow--;
                }
                start++;
            }
            maxLen = Math.max(end-start+1, maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {

    }
}
