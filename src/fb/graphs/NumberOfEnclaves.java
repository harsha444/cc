package fb.graphs;

public class NumberOfEnclaves {
    public static int numEnclaves(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[i].length - 1) {
                    dfs(grid, i, j);
                }
            }
        }

        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    result += 1;
                }
            }
        }
        return result;
    }

    private static void dfs(int[][] grid, int i, int j) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            dfs(grid, i + 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i - 1, j);
            dfs(grid, i, j - 1);
        }
    }

    public static void main(String[] args) {

    }
}
