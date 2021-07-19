package fb.graphs;

public class SurroundedRegions {
    public static void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        if (board.length < 3 || board[0].length < 3) {
            return;
        }
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }

        for (int j = 1; j < n - 1; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static void dfs(char[][] board, int i, int j) {
        if (i >= 0 && j >= 0 && i < board.length && j < board[0].length && board[i][j] == 'O') {
            board[i][j] = '1';
            dfs(board, i - 1, j);
            dfs(board, i, j - 1);
            dfs(board, i + 1, j);
            dfs(board, i, j + 1);
        }
    }

    public static void main(String[] args) {

    }
}
