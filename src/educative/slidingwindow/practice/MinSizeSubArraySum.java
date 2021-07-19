package educative.slidingwindow.practice;

public class MinSizeSubArraySum {
    public static int findMinSubArray(int s, int[] arr) {
        int start = 0;
        int currSum = 0;
        int minSubArrayLength = Integer.MAX_VALUE;
        for (int end = 0; end < arr.length; end++) {
            currSum = currSum + arr[end];
            while (currSum >= s) {
                minSubArrayLength = Math.min(minSubArrayLength, end - start + 1);
                currSum = currSum - arr[start];
                start += 1;
            }
        }
        return minSubArrayLength;
    }

    public static void main(String[] args) {
        System.out.println(findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 }));
    }
}
