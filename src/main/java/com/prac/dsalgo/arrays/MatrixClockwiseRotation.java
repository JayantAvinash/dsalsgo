package com.prac.dsalgo.arrays;

//https://leetcode.com/problems/rotate-image/
public class MatrixClockwiseRotation {

	public void rotate(int[][] matrix) {
		int size = matrix.length;
		for (int i = 0; i < size / 2; i++) {
			for (int j = i; j < size - i - 1; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[size - j - 1][i];
				matrix[size - j - 1][i] = matrix[size - i - 1][size - j - 1];
				matrix[size - i - 1][size - j - 1] = matrix[j][size - i - 1];
				matrix[j][size - i - 1] = temp;

			}
		}
	}

	public static void main(String[] args) {
		MatrixClockwiseRotation m = new MatrixClockwiseRotation();
		int [][]matrix = {
				  {1,2,3},
				  {4,5,6},
				  {7,8,9}
				};
		m.rotate(matrix);
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]);
			}
		System.out.println();
		}
	}

}
