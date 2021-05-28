package binarysearch;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstAndLast {
    public static int[] getLeftMostIndex(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int leftMostIndex = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                leftMostIndex = mid;
                r = mid - 1;
            }
        }
        return new int[] {leftMostIndex};
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 5, 7, 7, 8, 8, 10 };
        System.out.println(getLeftMostIndex(arr, 8)[0]);
    }
}
