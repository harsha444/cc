package fb;

import java.util.Arrays;

/*
 * n*n+1/2
 *
 * */
public class FindDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        findDuplicate(new int[] { 2, 1, 3, 4, 2 });
    }
}
