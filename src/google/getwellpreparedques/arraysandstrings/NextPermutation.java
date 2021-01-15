package google.getwellpreparedques.arraysandstrings;

import java.util.*;

public class NextPermutation {
	public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int swapAIndex=0;
        int check = 0;
        for(int i=n-1; i>0; i--) {
        	if(nums[i-1] < nums[i]) {
        		swapAIndex = i-1;
        		break;
        	}
        	check +=1;
        }
        if(check==n-1) {
	        reverse(nums, 0, n-1);
	        return;
        }
        boolean swapFound = false;
        for(int i=swapAIndex+1; i<n; i++) {
        	if(nums[i]<=nums[swapAIndex]) {
        		swap(nums, i-1, swapAIndex);
        		swapFound = true;
        		break;
        	}
        }
        if(!swapFound) {
	        swap(nums, swapAIndex, n-1);
        }
        reverse(nums, swapAIndex+1, n-1);
		for (int num : nums) {
			System.out.print(num);
		}
    }

    public static void reverse(int[] nums, int start, int end) {
    	while(start<end) {
    		swap(nums, start, end);
    		start+=1;
    		end-=1;
    	}
    }

    public static void swap(int[] nums, int start, int end) {
    	int temp;
    	temp = nums[end];
    	nums[end] = nums[start];
    	nums[start] = temp;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		nextPermutation(a);
	}
}