package google.contests;

import java.util.*;

public class RectanglesWithLargestSquare {
    public static int countGoodRectangles(int[][] rectangles) {
        int maxN = -10;
        int res = 0;
        for(int[] i: rectangles) {
            int maxIn = Math.min(i[0], i[1]);
            maxN = Math.max(maxIn, maxN);
        }
        for(int[] i: rectangles) {
            int minIn = Math.min(i[0], i[1]);
            if(minIn>=maxN) {
                res+=1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{2,3}, {3,7}, {4,3}, {3,7}};
        System.out.println(countGoodRectangles(a));
    }
}