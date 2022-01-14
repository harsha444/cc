package facebook.top100;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> m = new HashMap<>();
        int sumHere = 0;
        m.put(0, 1);
        for (int num : nums) {
            sumHere += num;
            if (m.containsKey(sumHere - k)) {
                result += m.get(sumHere - k);
            }
            m.put(sumHere, m.getOrDefault(sumHere, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
