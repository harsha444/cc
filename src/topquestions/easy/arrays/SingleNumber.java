package topquestions.easy.arrays;

import java.util.*;

public class SingleNumber {
	public static int singleNumber(int[] nums) {
		int result = nums[0];
        for(int i=1; i<nums.length; i++) {
        	result ^= nums[i];
        }
        return result;
    }

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] arr = new int[n];
		
	}
}