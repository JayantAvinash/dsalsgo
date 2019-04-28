package com.prac.dsalgo.dp;

public class MinStepsToReachMatrixEdge {

	public int minSteps(int[][] mat) {
		int cols = mat[0].length;
		int rows = mat.length;
		boolean[][] visited = new boolean[rows][cols];
		int min = Math.min(cols, rows);
		int[][] dp = new int[min][min];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = -1;
			}
		}
		int x = -1, y = -1;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == 2) {
					x = i;
					y = j;
					break;
				}
				if (x != -1) {
					break;
				}
			}
		}
		return getMinSteps(mat, x, y, dp, visited);

	}

	private int getMinSteps(int[][] mat, int x, int y, int[][] dp, boolean[][] visited) {
		if (x == 0 || y == 0 || x == mat.length - 1 || y == mat[0].length - 1) {
			return 0;
		}
		visited[x][y] = true;
		if (dp[x][y] != -1) {
			return dp[x][y];
		}
		int up = (int)1e9, down = (int)1e9, left = (int)1e9, right = (int)1e9;
		if (mat[x - 1][y] == 0 && !visited[x - 1][y]) {
			up = 1 + getMinSteps(mat, x - 1, y, dp, visited);
		}
		if (mat[x + 1][y] == 0 && !visited[x + 1][y]) {
			down = 1 + getMinSteps(mat, x + 1, y, dp, visited);
		}
		if (mat[x][y - 1] == 0 && !visited[x][y - 1]) {
			left = 1 + getMinSteps(mat, x, y - 1, dp, visited);
		}
		if (mat[x][y + 1] == 0 && !visited[x][y + 1]) {
			right = 1 + getMinSteps(mat, x, y + 1, dp, visited);
		}
		dp[x][y] = Math.min(up, Math.min(down, Math.min(left, right)));
		return dp[x][y];
	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 1, 1, 0, 1 }, { 1, 0, 2, 0, 1 }, { 0, 0, 1, 0, 1 }, { 1, 0, 1, 1, 0 } };
		MinStepsToReachMatrixEdge m = new MinStepsToReachMatrixEdge();
		System.out.println(m.minSteps(mat));
	}

}
