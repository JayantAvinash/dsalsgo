package com.prac.dsalgo.dp;

public class StockMaxProfit {
	
	static long stockmax(int[] prices) {
        long profit = 0l;
        int maxSoFar = 0;
        for (int i = prices.length - 1; i >= 0 ; i--) {
            if (prices[i] > maxSoFar) {
                maxSoFar = prices[i];
            }
            profit += maxSoFar - prices[i];
        }
        return profit;

    }


	public static void main(String[] args) {
		int []prices = {5, 4, 3, 4, 5};
		System.out.println(StockMaxProfit.stockmax(prices));

	}

}
