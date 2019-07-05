package com.prac.dsalgo.dp;

// https://leetcode.com/problems/unique-paths-ii/
public class UniquePathsObstacleMatrix {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		if (m < 1) {
			return 0;
		}
		int n = obstacleGrid[0].length;
		if (n < 1) {
			return 0;
		}
		if (obstacleGrid[m - 1][n - 1] == 1) {
			return 0;
		}
		int[][] paths = new int[m][n];
		paths[0][0] = 1;
		for (int i = 1; i < m; i++) {
			paths[i][0] = (obstacleGrid[m - i - 1][n - 1] == 1 || paths[i - 1][0] == 0) ? 0 : 1;
		}
		for (int j = 1; j < n; j++) {
			paths[0][j] = (obstacleGrid[m - 1][n - j - 1] == 1 || paths[0][j - 1] == 0) ? 0 : 1;
		}
		for (int i = 1; i < m; i++) {
			boolean possible = false;
			for (int j = 1; j < n; j++) {
				paths[i][j] = obstacleGrid[m - i - 1][n - j - 1] == 1 ? 0 : paths[i][j - 1] + paths[i - 1][j];
				if (paths[i][j] > 0) {
					possible = true;
				}
			}
			if (!possible && paths[i][0] == 0) {
				return 0;
			}
		}
		return paths[m - 1][n - 1];
	}

	public int uniquePathsWithObstacles1D(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		if (m < 1) {
			return 0;
		}
		int n = obstacleGrid[0].length;
		if (n < 1) {
			return 0;
		}
		if (obstacleGrid[m - 1][n - 1] == 1) {
			return 0;
		}
		int[] number = new int[n];
		number[0] = 1;
		for (int[] row : obstacleGrid) {
			boolean possible = false;
			for (int j = 0; j < n; j++) {
				if (row[j] == 1) {
					number[j] = 0;
				} else if (j > 0) {
					possible = true;
					number[j] += number[j - 1];
				}
			}
			if (!possible && row[0] == 1) {
				return 0;
			}
		}
		return number[n - 1];
	}

	public static void main(String[] args) {
		UniquePathsObstacleMatrix u = new UniquePathsObstacleMatrix();
		int[][] obstacle = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		System.out.println(u.uniquePathsWithObstacles(obstacle));
		System.out.println(u.uniquePathsWithObstacles1D(obstacle));
	}

}
