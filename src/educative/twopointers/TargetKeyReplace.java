package educative.twopointers;

public class TargetKeyReplace {
    public int removeElement(int[] nums, int val) {
        int curr = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=val) {
                nums[curr] = nums[i];
                curr+=1;
            }
        }
        return curr;
    }

    public static void main(String[] args) {

    }
}
