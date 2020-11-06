package interviewbit.arrays;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class SpiralMatrix {
    static void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void spiralOrderTraversal(int[][] m) {
        int l = 0, t = 0, b = m.length, r = m[0].length, dir = 0;
        ArrayList<Integer> response = new ArrayList<>();
        while (l < r && t < b) {
            if (dir == 0) {
                for (int i = l; i < r; i++) {
                    response.add(m[t][i]);
                }
                t++;
                dir = 1;
            }
            else if (dir == 1) {
                for (int i = t; i < b; i++) {
                    response.add(m[i][r - 1]);
                }
                r--;
                dir = 2;
            }
            else if (dir == 2) {
                for (int i = r - 1; i >= l; i--) {
                    response.add(m[b - 1][i]);
                }
                b--;
                dir = 3;
            }
            else if (dir == 3) {
                for (int i = b - 1; i >= t; i--) {
                    response.add(m[i][l]);
                }
                l++;
                dir = 0;
            }
        }
        System.out.println(response.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] inputMatrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                inputMatrix[i][j] = sc.nextInt();
            }
        }
        printMatrix(inputMatrix);
        spiralOrderTraversal(inputMatrix);
    }
}
