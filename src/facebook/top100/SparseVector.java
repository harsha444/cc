package facebook.top100;

import java.util.HashMap;
import java.util.Map;

public class SparseVector {
    Map<Integer, Integer> indexValueMap = new HashMap<>();

    public SparseVector(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                indexValueMap.put(i, nums[i]);
            }
        }
    }

    public int dotProduct(SparseVector vec) {
        if (vec.indexValueMap.size() < indexValueMap.size()) {
            return vec.dotProduct(this);
        }
        int response = 0;
        for (Map.Entry<Integer, Integer> m : indexValueMap.entrySet()) {
            int index = m.getKey();
            int value = m.getValue();
            if (vec.indexValueMap.containsKey(index)) {
                response += (value * vec.indexValueMap.get(index));
            }
        }
        return response;
    }
}
