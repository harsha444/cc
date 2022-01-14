package facebook.slidingwindow;

import java.util.*;

public class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        int minWindowSize = Integer.MAX_VALUE;
        int windowStart = 0;
        int windowSum = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            while (windowSum >= S) {
                minWindowSize = Math.min(windowEnd - windowStart + 1, minWindowSize);
                windowSum -= arr[windowStart];
                windowStart += 1;
            }
        }
        return minWindowSize == Integer.MAX_VALUE ? 0 : minWindowSize;
    }

    public static void main(String[] args) {

    }
}