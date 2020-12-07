package dev.codefoundry.matrix;

import java.util.Arrays;

public class MatrixTranspose {
	public int[][] solve(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		for (int row = 0; row < rows; row++) {
			for (int col = row; col < cols; col++) {
				int rc = matrix[row][col];
				matrix[row][col] = matrix[col][row];
				matrix[col][row] = rc;
			}
		}
		
		return matrix;
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		
		System.out.println(Arrays.deepToString(new MatrixTranspose().solve(matrix)));
	}
}
