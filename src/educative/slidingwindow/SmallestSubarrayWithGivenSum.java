package educative.slidingwindow;

public class SmallestSubarrayWithGivenSum {
    public static int findMinSubArray(int S, int[] arr) {
        int minLen = Integer.MAX_VALUE;
        int windowSum = arr[0];
        int s = 0;
        for (int e = 0; e < arr.length; e++) {
            windowSum += arr[e];
            while (windowSum >= S) {
                minLen = Math.min(minLen, e - s + 1);
                windowSum -= arr[s];
                s++;
            }
        }
        return minLen;
    }

    public static void main(String[] args) {

    }
}
