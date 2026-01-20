package prac2026.blind75;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] response = new int[2];
        for(int i=0; i<len; i++) {
            int curr = nums[i];
            int req = target - nums[i];
            if(map.get(req)!=null) {
                response[0] = map.get(req);
                response[1] = i;
                return response;
            }
            map.put(curr, i);
        }
        return response;
    }
}
