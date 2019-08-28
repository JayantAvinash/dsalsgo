package com.prac.dsalgo.general;

// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
public class NumDiceRollsToTarget {

	public int numRollsToTarget1DArr(int d, int f, int target) {
		if (d * f < target || target < d) {
			return 0;
		}
		if (d * f == target || target == d) {
			return 1;
		}
		int mod = 1000000007;
		long[] num = new long[target + 1];
		num[0] = 1;
		for (int i = 0; i < d; i++) {
			long[] current = new long[target + 1];
			for (int j = 0; j <= target; j++) {
				for (int k = 1; k <= f; k++) {
					if (j + k <= target) {
						current[j + k] += num[j];
						current[j + k] = current[j + k] % mod;
					}
				}
			}
			num = current.clone();
		}
		return (int) (num[target]);
	}

	public int numRollsToTarget(int d, int f, int target) {
		if (d * f < target || target < d) {
			return 0;
		}
		if (d * f == target || target == d) {
			return 1;
		}
		int mod = 1000000007;
		long[][] num = new long[d + 1][target + 1];
		for (int face = 1; face <= f; face++) {
			if (face <= target) {
				num[1][face] = 1;
			}
		}
		for (int i = 2; i <= d; i++) {
			for (int j = 1; j <= target; j++) {
				for (int k = 1; k <= f; k++) {
					if (j - k >= 0) {
						num[i][j] += num[i - 1][j - k];
						num[i][j] %= mod;
					}
				}
			}
		}
		return (int) (num[d][target]);
	}

	public static void main(String[] args) {
		NumDiceRollsToTarget n = new NumDiceRollsToTarget();
		System.out.println(n.numRollsToTarget(30, 30, 500));
	}

}
