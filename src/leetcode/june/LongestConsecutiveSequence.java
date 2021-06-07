package leetcode.june;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int res = 0;
        for (int i : nums) {
            s.add(i);
        }
        for (int num: nums) {
            if(!s.contains(num-1)) {
                int currChain = 1;
                int curr = num+1;
                while(s.contains(curr)) {
                    currChain+=1;
                    curr++;
                }
                res = Math.max(res, currChain);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
