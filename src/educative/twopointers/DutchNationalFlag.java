package educative.twopointers;

public class DutchNationalFlag {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        for (int i = 0; i <= end; ) {
            if (nums[i] == 0) {
                swap(nums, i, start);
                start+=1;
                i+=1;
            } else if (nums[i] == 1) {
                i+=1;
            } else {
                swap(nums, end, i);
                end-=1;
            }
        }
    }

    public static void main(String[] args) {

    }
}
