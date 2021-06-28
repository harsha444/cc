package educative.twopointers;

import java.util.*;

public class ShortestUnsortedSubArray {
    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        if(n==1) {
            return 0;
        }
        int start = 0;
        int end = n - 1;
        while (start < n - 1 && nums[start] <= nums[start + 1]) {
            start += 1;
        }
        while (end > 0 && nums[end] >= nums[end - 1]) {
            end -= 1;
        }
        if (start == n - 1) {
            return 0;
        }
        if (start == 0 && end == n - 1) {
            return n;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        while(start>0 && nums[start-1]>min) {
            start-=1;
        }

        while(end<nums.length-1 && nums[end+1]<max) {
            end+=1;
        }

        return end - start + 1;
    }

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{1,3,2,3,3}));
    }
}