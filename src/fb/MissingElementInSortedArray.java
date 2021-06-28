package fb;

public class MissingElementInSortedArray {
    public static int missingElement(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0] + k;
        }
        int currMiss = 0;
        for (int i = 1; i < nums.length; i++) {
            currMiss = (currMiss + nums[i] - nums[i - 1] - 1);
            if (currMiss >= k) {
                return nums[i] - (currMiss - k + 1);
            }
        }
        return nums[nums.length - 1] + (k - currMiss);
    }

    public static void main(String[] args) {
        System.out.println(missingElement(new int[] { 4, 7, 9, 10 }, 1));
        System.out.println(missingElement(new int[] { 4, 7, 9, 10 }, 3));
        System.out.println(missingElement(new int[] { 1, 2, 4 }, 3));
    }
}
