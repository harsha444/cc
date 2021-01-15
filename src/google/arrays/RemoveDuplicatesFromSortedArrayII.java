package google.arrays;

import java.util.*;

public class RemoveDuplicatesFromSortedArrayII {
	public static int removeDuplicates(int[] nums) {
		int j = 1;
		int i = 0;
		int currCount = 1;
		while(i<nums.length && j<nums.length) {
			if(nums[j] == nums[i] && currCount<2) {
				currCount += 1;
				nums[++i] = nums[j];
				j+=1;
				continue;
			} else if(nums[j] == nums[i]) {
				j+=1;
				continue;
			} else {
				currCount = 1;
				nums[++i] = nums[j];
				j++;
			}
		}
		return i+1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		System.out.print(removeDuplicates(a));
		System.out.print(Arrays.toString(a));
	}
}