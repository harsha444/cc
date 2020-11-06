package interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

public class MaxContiguousSubArray {
    public static int maxSubArray(List<Integer> A) {
        int start = 0, end = 0, s = 0, e = 0, maxHere = 0, totalMax = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            maxHere = maxHere + A.get(i);
            if (totalMax < maxHere) {
                totalMax = maxHere;
                start = s;
                end = i;
            }
            if (maxHere < 0) {
                maxHere = 0;
                s = i + 1;
            }
        }
        return totalMax;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        System.out.println(maxSubArray(input));
    }
}
