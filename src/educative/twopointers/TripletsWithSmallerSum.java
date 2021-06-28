package educative.twopointers;

import java.util.Arrays;

public class TripletsWithSmallerSum {
    public static int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            int start = i + 1;
            int end = n - 1;
            while (start < end) {
                int currSum = nums[i] + nums[start] + nums[end];
                if (currSum < target) {
                    count += (end - start);
                    start++;
                } else {
                    end--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(threeSumSmaller(new int[] { -2, 0, 1, 3 }, 2));
    }
}
