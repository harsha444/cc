package educative.cyclicsort;

public class FindCorruptNums {
    public static int[] findNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }

        return new int[] { -1, -1 };
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        findNumbers(new int[] {3, 1, 2, 5, 2});
    }
}
