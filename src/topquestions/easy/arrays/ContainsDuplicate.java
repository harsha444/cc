package topquestions.easy.arrays;

import java.util.*;

public class ContainsDuplicate {
	public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++) {
        	if(set.contains(nums[i])) {
        		return false;
        	}
        	set.add(nums[i]);
        }
        return true;
    }
}