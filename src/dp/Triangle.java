package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j));
                    continue;
                }
                if (j == triangle.get(i).size() - 1) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j - 1));
                    continue;
                }
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j)));
            }
        }
        List<Integer> last = triangle.get(triangle.size() - 1);
        return last.stream().min(Integer::compare).get();
    }

    public static void main(String[] args) {
        List<List<Integer>> l = new ArrayList<>();
        l.add(Arrays.asList(2));
        l.add(Arrays.asList(3, 4));
        l.add(Arrays.asList(6, 5, 7));
        l.add(Arrays.asList(4, 1, 8, 3));
        minimumTotal(l);
    }
}
