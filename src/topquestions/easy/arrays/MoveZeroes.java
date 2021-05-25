package topquestions.easy.arrays;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        int i=0;
        for(int j=0; j<nums.length; j++) {
        	if(nums[j]>0) {
        		nums[i] = nums[j];
        		i+=1;
        	}
        }
        for(int j=i; j<len; j++){
            nums[j] = 0;
        }
    }

    public static void main(String[] args) {
        
    }
}
