package educative.slidingwindow;

public class MaximumSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int windowSum = arr[0];
        int s = 0;
        for (int e = 1; e < arr.length; e++) {
            windowSum += arr[e];
            if (e >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[s];
                s+=1;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
    }
}
