package com.prac.dsalgo.dp;

// https://leetcode.com/problems/unique-paths/
public class UniquePathsMatrix {

	public int uniquePaths(int m, int n) {
		if (m < 1 || n < 1) {
			return 0;
		}
		if (m == 1 || n == 1) {
			return 1;
		}
		int[][] number = new int[m][n];
		for (int i = 0; i < m; i++) {
			number[i][0] = 1;
		}
		for (int j = 0; j < n; j++) {
			number[0][j] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				// can also be done with 1D array as we need value for i - 1
				// (please see next method)
				number[i][j] = number[i - 1][j] + number[i][j - 1];
			}
		}
		return number[m - 1][n - 1];
	}

	public int uniquePathsLessMemory(int m, int n) {
		if (m < 1 || n < 1) {
			return 0;
		}
		if (m == 1 || n == 1) {
			return 1;
		}
		int[] number = new int[n];
		number[0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				// number[current i][j] = number[previous i][j] + number[current
				// i][j - 1]
				// can be done with 1D array;
				number[j] += number[j - 1];
			}
		}
		return number[n - 1];
	}

	// we have to travel total m + n -2 paths; m - 1 horizontal and n - 1
	// vertical
	// number of ways to choose n - 1 vertical out of total m + n - 2 is is
	// combinatorial(m + n - 2, n -1) i.e. (m + n - 2)C( n - 1)
	public int uniquePathsComninatorial(int m, int n) {
		if (m < 1 || n < 1) {
			return 0;
		}
		if (m == 1 || n == 1) {
			return 1;
		}
		double number = 1;
		for (int i = n; i < m + n - 1; i++) {
			number *= i;
			number /= (i - n + 1);
		}
		return (int) number;
	}

	public static void main(String[] args) {
		UniquePathsMatrix u = new UniquePathsMatrix();
		System.out.println(u.uniquePaths(7, 7));
		System.out.println(u.uniquePathsLessMemory(7, 7));
		System.out.println(u.uniquePathsComninatorial(7, 7));

	}

}
