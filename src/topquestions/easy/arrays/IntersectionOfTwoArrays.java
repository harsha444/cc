package topquestions.easy.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArrays {
    public static int[] intersect(int[] nums1, int[] nums2) {
        //        nums1 = [4,9,5]
        //        m = 4->1, 9->1, 5->1
        Map<Integer, Integer> m = new HashMap<>();
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        for (int j : nums1) {
            m.put(j, m.getOrDefault(j, 0) + 1);
        }
        int count = 0;
        for (int j : nums2) {
            int cnt = m.getOrDefault(j, 0);
            if (cnt > 0) {
                nums1[count] = j;
                count += 1;
                m.put(j, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, count);
    }

    public static void main(String[] args) {

    }
}
