package educative.twopointers;

import java.util.Arrays;

public class TripletSumCloseToK {
    public static int searchTriplet(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int n = arr.length;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && arr[i - 1] == arr[i]) {
                // ignoring duplicate triplets
                continue;
            }
            int start = i + 1;
            int end = arr.length-1;
            while (start < end) {
                int currDiff = targetSum - arr[i] - arr[start] - arr[end];
                if (currDiff == 0) {
                    return arr[i] + arr[start] + arr[end];
                }
                if (Math.abs(currDiff) < Math.abs(minDiff) || (Math.abs(currDiff) == Math.abs(minDiff) && currDiff > minDiff)) {
                    minDiff = currDiff;
                }
                if (currDiff > 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {

    }
}
