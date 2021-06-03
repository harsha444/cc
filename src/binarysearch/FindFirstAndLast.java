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
        return new int[] { leftMostIndex };
    }

    public static int getLeftIndex(int[] nums, int target) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        int leftMostIndex = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                leftMostIndex = mid;
                r = mid - 1;
            }
        }
        return leftMostIndex;
    }

    public static int getRightIndex(int[] nums, int target) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        int rightMostIndex = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                rightMostIndex = mid;
                l = mid + 1;
            }
        }
        return rightMostIndex;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] resp = new int[] { -1, -1 };
        int leftIndex = getLeftIndex(nums, target);
        resp[0] = leftIndex;
        if (leftIndex == -1) {
            return resp;
        } else {
            int rightIndex = getRightIndex(nums, target);
            resp[1] = rightIndex;
        }
        return resp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 5, 7, 7, 8, 8, 8, 10 };
        System.out.println(getLeftIndex(arr, 8));
    }
}
