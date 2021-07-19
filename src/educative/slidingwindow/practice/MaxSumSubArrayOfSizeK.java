package educative.slidingwindow.practice;

public class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int start = 0;
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int end = 0; end < arr.length; end++) {
            windowSum = windowSum + arr[end];
            if (end >= k) {
                windowSum -= arr[start];
                start++;
                maxSum = Math.max(windowSum, maxSum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
    }
}
