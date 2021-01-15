package google.getwellpreparedques.arraysandstrings;

import java.util.*;

public class RotateImage {
	public static void transpose(int[][] matrix) {
		for(int i=0; i< matrix.length; i++) {
			for(int j=i; j<matrix.length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	public static void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }

    public static void reverse(int[][] matrix) {
		int n = matrix.length;
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n/2; j++) {
    			int temp = matrix[i][j];
    			matrix[i][j] = matrix[i][n-j-1];
    			matrix[i][n-j-1] = temp;
		    }
	    }
    }

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
		rotate(matrix);
		for(int[] i: matrix) {
			for(int j: i) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
}