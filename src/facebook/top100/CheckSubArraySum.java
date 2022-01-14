package facebook.top100;

import java.util.HashMap;
import java.util.Map;

public class CheckSubArraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        int runningSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            runningSum = k == 0 ? runningSum : runningSum % k;
            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - prev > 1) {
                    return true;
                }
            } else {
                map.put(runningSum, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[] { 23, 2, 4, 6, 6 }, 7));
    }
}
