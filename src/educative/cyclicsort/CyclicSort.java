package educative.cyclicsort;

import java.util.Arrays;

public class CyclicSort {
    public static void sort(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] != i + 1) {
                swap(nums, i, nums[i] - 1);
            }
            if (nums[i] == i + 1) {
                i++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] resp = new int[] {2,6,4,3,1,5};
        sort(resp);
        System.out.println(Arrays.toString(resp));
    }
}
