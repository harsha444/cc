package google.contests;

import java.util.*;

public class TupleWithSameProduct {
    public static int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (!m.containsKey(nums[i] * nums[j])) {
                    m.put(nums[i] * nums[j], 1);
                } else {
                	m.put(nums[i] * nums[j], m.get(nums[i] * nums[j])+1);
                }
            }
        }
        for(Map.Entry<Integer, Integer> i: m.entrySet()) {
        	if(i.getValue()>1) {
        		res += (i.getValue()*(i.getValue()-1)/2)*8;
	        }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[] { 2, 3, 4, 6, 8, 12 };
        System.out.print(tupleSameProduct(a));
    }
}