package leetcode.june;

import java.util.Arrays;

public class MaximumAreaAfterHorizontalAndVerticalLines {
    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long maxHDiff = horizontalCuts[0];
        long maxWDiff = verticalCuts[0];
        for (int i = 1; i < horizontalCuts.length; i++) {
            maxHDiff = Math.max(maxHDiff, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        maxHDiff = Math.max(maxHDiff, h - horizontalCuts[horizontalCuts.length - 1]);

        for (int i = 1; i < verticalCuts.length; i++) {
            maxWDiff = Math.max(maxWDiff, verticalCuts[i] - verticalCuts[i - 1]);
        }
        maxWDiff = Math.max(maxWDiff, w - verticalCuts[verticalCuts.length - 1]);
        return (int) ((maxHDiff*maxWDiff) % (1e9+7));
    }

    public static void main(String[] args) {
        System.out.println(maxArea(5, 2, new int[] { 3, 1, 2 }, new int[] { 1 }));
    }
}
