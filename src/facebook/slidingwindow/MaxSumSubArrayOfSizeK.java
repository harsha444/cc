package facebook.slidingwindow;

import java.util.*;

public class MaxSumSubArrayOfSizeK {
	public static int findMaxSumSubArray(int k, int[] arr) {
		int windowStart = 0;
		int windowSum = 0;
		int maxSum = Integer.MIN_VALUE;
		for(int windowEnd=0; windowEnd<arr.length; windowEnd++) {
			windowSum += arr[windowEnd];
			if(windowEnd>=k-1) {
				maxSum = Math.max(maxSum, windowSum);
				windowSum -= arr[windowStart];
				windowStart += 1;
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		
	}
}