package facebook.top100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland {
    private int[][] directions = new int[][] { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

    private int getIslandSize(int i, int j, int[][] grid, int islandId) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = islandId;
        int left = getIslandSize(i, j - 1, grid, islandId);
        int up = getIslandSize(i - 1, j, grid, islandId);
        int right = getIslandSize(i, j + 1, grid, islandId);
        int down = getIslandSize(i + 1, j, grid, islandId);
        return left + right + up + down + 1;
    }

    public int largestIsland(int[][] grid) {
        int result = Integer.MIN_VALUE;
        Map<Integer, Integer> islandIdToSizeMap = new HashMap<>();
        int islandId = 2;
        int nRows = grid.length;
        int nCols = grid[0].length;
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (grid[i][j] != 0) {
                    int islandSize = getIslandSize(i, j, grid, islandId);
                    result = Math.max(result, islandSize);
                    islandIdToSizeMap.put(islandId++, islandSize);
                }
            }
        }
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    for (int[] direction : directions) {
                        int x = direction[0] + i;
                        int y = direction[1] + j;
                        if (x >= 0 && y >= 0 && x < nRows && y < nRows && grid[x][y] != 0) {
                            set.add(grid[x][y]);
                        }
                    }
                    int max = 1;
                    for (int s : set) {
                        max += islandIdToSizeMap.get(s);
                    }
                    result = Math.max(result, max);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
