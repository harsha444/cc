package google.arrays;

import java.util.*;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/

/*
1,1,1,2,2,4,5,6
i=2,j=6
sz=7
*/

public class RemoveSortedArrayDuplicates {
    public static int removeDuplicates(int[] nums) {
        int sz = nums.length;
        int i = 0;
        int j = 0;
        while (i < sz && j < sz) {
            if (nums[j] == nums[i]) {
                j++;
                continue;
            }
            ++i;
            nums[i] = nums[j];
            j++;
        }
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(removeDuplicates(a));
    }
}