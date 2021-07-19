package fb.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WallsAndGates {
    private static final int EMPTY = Integer.MAX_VALUE;

    private static final int GATE = 0;

    private static final List<int[]> DIRECTIONS = Arrays.asList(new int[] { 1, 0 }, new int[] { -1, 0 }, new int[] { 0, 1 }, new int[] { 0, -1 });

    public static void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == GATE) {
                    queue.add(new int[] { i, j });
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int row = point[0];
            int col = point[1];
            for (int[] direction : DIRECTIONS) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                if (row < 0 || row >= rooms.length || col < 0 || col > rooms[0].length || rooms[row][col] != EMPTY) {
                    continue;
                }
                rooms[nextRow][nextCol] = rooms[row][col] + 1;
                queue.add(new int[] { nextRow, nextCol });
            }
        }
    }

    public static void main(String[] args) {

    }
}
