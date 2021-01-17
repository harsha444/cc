package google.contests;

import java.util.*;

public class LargestMatrixWithRearrangements {
	public static int largestSubmatrix(int[][] matrix) {
		int response = 0;

        for(int i=0; i<matrix.length; i++) {
        	for(int j=0; j<matrix[i].length; j++) {
                if(i!=0 && matrix[i][j]!=0) {
                    matrix[i][j] += matrix[i-1][j];
                }
        	}
        }

        for(int i=0; i<matrix.length; i++) {
            Arrays.sort(matrix[i]);
            for(int j=0; j<matrix[i].length; j++) {
                response = Math.max(response, (matrix[i].length-j)*matrix[i][j]);
            }
        }

        return response;
    }

	public static void main(String[] args) {
		int[][] a = new int[][]{{1,0,1,0,1}};
		System.out.println(largestSubmatrix(a));
	}
}