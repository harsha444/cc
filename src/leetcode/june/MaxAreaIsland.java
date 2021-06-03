package leetcode.june;

public class MaxAreaIsland {
    private static int maxAreaUtil(int r, int c, int[][] grid, boolean[][] visited) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || visited[r][c] || grid[r][c] == 0) {
            return 0;
        }
        visited[r][c] = true;
        return (1 + maxAreaUtil(r + 1, c, grid, visited)
                + maxAreaUtil(r - 1, c, grid, visited)
                + maxAreaUtil(r, c + 1, grid, visited)
                + maxAreaUtil(r, c - 1, grid, visited));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int resp = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                resp = Math.max(resp, maxAreaUtil(i, j, grid, visited));
            }
        }
        return resp;
    }

    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(
                new int[][] { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } }));
    }
}
