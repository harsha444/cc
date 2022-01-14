package facebook.top100;

import java.util.ArrayList;
import java.util.List;

public class BuildingsWithOceanView1762 {
    public int[] findBuildings(int[] heights) {
        List<Integer> response = new ArrayList<>();
        int maxTillNow = Integer.MIN_VALUE;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > maxTillNow) {
                response.add(i);
                maxTillNow = heights[i];
            }
        }
        int[] resp = new int[response.size()];
        int j = 0;
        for (int i = response.size() - 1; i >= 0; i--) {
            resp[j] = response.get(i);
            j++;
        }
        return resp;
    }

    public static void main(String[] args) {

    }
}
