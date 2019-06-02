package com.prac.dsalgo.dp;

/*https://leetcode.com/problems/coin-change-2/
*/public class CoinChangeCombinations {
	
	public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin : coins) {
            for(int i = 1; i <= amount; i++) {
                if(i - coin >= 0) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }

	public static void main(String[] args) {
		int[] coins = {1, 2, 5};
		CoinChangeCombinations c = new CoinChangeCombinations();
		System.out.println(c.change(5, coins));

	}

}
