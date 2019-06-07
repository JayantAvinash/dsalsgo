package com.prac.dsalgo.dp;

import java.util.Arrays;
import java.util.List;

//https://www.geeksforgeeks.org/optimal-strategy-for-a-game-dp-31/

public class CoinMaxValue {
	
	public int getMaxCoinValue(List<Integer> coins) {
		return getMaxCoinValue(coins, 0, coins.size() - 1);
	}

	private int getMaxCoinValue(List<Integer> coins, int from, int to) {
		if(from > to) {
			return 0;
		}
		int x = getMaxCoinValue(coins, from + 2, to);
		int y = getMaxCoinValue(coins, from + 1, to - 1);
		int z = getMaxCoinValue(coins, from, to - 2);
		
		int a  = coins.get(from) + (x > y ? y : x);
		int b  = coins.get(to) + (y > z ? z : y);
		return Math.max(a, b);
	}
	
	public int getMaxCoinValueDP(List<Integer> coins) {
		int size = coins.size();
		int [][]dp = new int[size][size];
		for(int j = 0; j < size - 1; j++) {
			dp[j][j + 1] = Math.max(coins.get(j), coins.get(j + 1));
		}
		for(int total = 4; total <= size; total += 2) {
			for(int i = 0; i <= size - total; i++) {
				int j = total + i - 1;
				if(i > j) {
					break;
				}
				int a = coins.get(i) + (dp[i + 1][j - 1] > dp[i + 2][j] ? dp[i + 2][j] : dp[i + 1][j - 1]);
				int b = coins.get(j) + (dp[i][j - 2] > dp[i + 1][j - 1] ? dp[i + 1][j - 1] : dp[i][j - 2]);
				dp[i][j] = Math.max(a, b);
			}
		}
		return dp[0][size - 1];
	}

	public static void main(String[] args) {
		Integer []arr = {72, 15, 56, 72, 13, 76};
		List<Integer> coins = Arrays.asList(arr);
		CoinMaxValue cmv = new CoinMaxValue();
		System.out.println(cmv.getMaxCoinValueDP(coins));
	}

}
