package leetcode.june;

import java.util.Arrays;

public class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int res = 0;
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        for (int[] box : boxTypes) {
            int nBoxes = Math.min(box[0], truckSize);
            if (truckSize > 0) {
                res += nBoxes * box[1];
            }
            truckSize -= nBoxes;
            if (truckSize <= 0) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
