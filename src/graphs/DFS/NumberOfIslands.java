package graphs.DFS;

public class NumberOfIslands {
    private static boolean isIsland(int r, int c, char[][] grid, boolean[][] visited) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || visited[r][c] || grid[r][c] == '0') {
            return false;
        }
        visited[r][c] = true;
        isIsland(r + 1, c, grid, visited);
        isIsland(r - 1, c, grid, visited);
        isIsland(r, c + 1, grid, visited);
        isIsland(r, c - 1, grid, visited);
        return true;
    }

    public static int numIslands(char[][] grid) {
        int resp = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (isIsland(i, j, grid, visited)) {
                    resp += 1;
                }
            }
        }
        return resp;
    }

    public static void main(String[] args) {

    }
}
