package fb;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> resp = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0) {
                resp.add(Math.abs(nums[i]));
            } else {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }
        return resp;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[] { 1, 1 }));
    }
}
