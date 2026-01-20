package prac2026.blind75;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> duplicates = new HashSet<>();
        for(int num: nums) {
            if(duplicates.contains(num)) {
                return true;
            }
            duplicates.add(num);
        }
        return false;
    }
}
