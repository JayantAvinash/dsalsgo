package com.prac.dsalgo.dp;

public class MatrixChainMultiplication {

	/**
	 * @param arr
	 * @return Minimum no of multiplication steps
	 */

	// Matrix Ai has dimension arr[i-1] x arr[i] for i = 1..n
	public int minMultiplicationDP(int[] arr) {
		int n = arr.length;
		int[][] minSteps = new int[n][n];

		for (int total = 2; total < n; total++) {
			for (int i = 1; i < n - total + 1; i++) {
				int j = i + total - 1;
				if (j == n) {
					continue;
				}
				minSteps[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					int val = arr[i - 1] * arr[k] * arr[j] + minSteps[i][k] + minSteps[k + 1][j];
					minSteps[i][j] = Math.min(minSteps[i][j], val);
				}
			}
		}
		return minSteps[1][n - 1];
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 2, 3, 4 };
		MatrixChainMultiplication mc = new MatrixChainMultiplication();
		System.out.println("Minimum number of multiplications is " + mc.minMultiplicationDP(arr));
	}

}
