package google.arrays;

import java.util.*;

// https://leetcode.com/problems/rotate-array/solution/

public class RotateArray {
	public static void rotate(int[] nums, int k) {
		int len = nums.length;
        k = k%len;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int s = len-k;
        for(int i=s; i<len; i++) {
        	temp.add(nums[i]);
        }
        for(int i=0; i<s; i++) {
        	temp.add(nums[i]);
        }
        for (int i=0; i<len; i++) {
        	nums[i] = temp.get(i);
        }
		System.out.println(temp);
    }

	public static void main(String[] args) {
		int [] a = new int[] {1,2,3,4,5,6};
		rotate(a, 8);
	}
}