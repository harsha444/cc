package geeks.mustdoquestions.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    public static void subArraySum(int[] arr, int n, int sum) {
        int currSum = 0;
        int start = 0;
        int end = -1;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (sum - currSum == 0) {
                start = 0;
                end = i;
                break;
            }
            if (hashMap.containsKey(currSum - sum)) {
                start = hashMap.get(currSum - sum) + 1;
                end = i;
                break;
            }
            hashMap.put(currSum, i);
        }
        if (end == -1) {
            System.out.print("No subarray found");
        } else {
            System.out.print("Start: " + start + " End: " + end);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 2, -2, -20, 10 };
        int n = arr.length;
        int sum = -10;
        subArraySum(arr, n, sum);
    }
}
