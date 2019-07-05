package com.prac.dsalgo.dp;

// https://leetcode.com/problems/coin-change/
public class CoinChangeProblem {

	public int coinChange(int[] coins, int amount) {
		if (amount <= 0) {
			return 0;
		}
		if (coins == null || coins.length == 0) {
			return -1;
		}
		int[] amounts = new int[amount + 1];
		for (int i = 1; i <= amount; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (i == coins[j]) {
					min = 1;
					break;
				}
				if (i - coins[j] > 0 && amounts[i - coins[j]] > 0) {
					min = Math.min(1 + amounts[i - coins[j]], min);
				}
			}
			amounts[i] = min != Integer.MAX_VALUE ? min : 0;
		}
		return amounts[amount] > 0 ? amounts[amount] : -1;
	}

	public static void main(String[] args) {
		CoinChangeProblem c = new CoinChangeProblem();
		int[] arr = { 1, 2, 5 };
		System.out.println(c.coinChange(arr, 11));
	}

}
