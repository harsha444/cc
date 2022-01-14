package educative.mergeinterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Stack<int[]> s = new Stack<>();
        for (int[] i : intervals) {
            int first = i[0];
            int second = i[1];
            if (s.isEmpty()) {
                s.push(i);
                continue;
            }
            int[] top = s.pop();
            int topFirst = top[0];
            int topSecond = top[1];
            /* [1,4], [2,3]
             * [1,3], [4,5]
             * */
            if (first > topSecond) {
                s.push(top);
                s.push(i);
            } else {
                if (second <= topSecond) {
                    s.push(top);
                } else {
                    s.push(new int[] { topFirst, second });
                }
            }
        }
        int[][] response = new int[s.size()][2];
        List<int[]> respList = new ArrayList<>(s);
        for (int i = respList.size()-1; i >=0; i--) {
            response[i] = respList.get(i);
        }
        return response;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } })));
    }
}
