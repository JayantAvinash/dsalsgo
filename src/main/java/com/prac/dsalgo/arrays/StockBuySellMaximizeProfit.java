package com.prac.dsalgo.arrays;

import java.util.ArrayList;
import java.util.List;

public class StockBuySellMaximizeProfit {
	
	// Buy once sell once
	public int maxProfitBOSO(int []prices) {
		if(prices.length == 0) {
			return 0;
		}
		int maxProfit = 0;
		int minBuyPrice = prices[0];
		for(int i = 0; i < prices.length; i++) {
			if(prices[i] <= minBuyPrice) {
				minBuyPrice = prices[i];
			} else {
				maxProfit = Math.max(maxProfit, prices[i] - minBuyPrice);
			}
		}
		return maxProfit;
	}
	
	// Buy multiple times sell multiple times
	public int maxProfit(int []prices) {
		if(prices.length == 0) {
			return 0;
		}
		int n = prices.length;
		int i = 0;
		List<List<Integer>> intervals = new ArrayList<>();
		while(i < n) {
			while(i < n - 1 && prices[i + 1] <= prices[i]) {
					i++;
			}
			if(i == (n - 1)) {
				break;
			}
			int start = i;
			while(i < n - 1 && prices[i] <= prices[i + 1]) {
				i++;
			}
			List<Integer> current = new ArrayList<>();
			current.add(start);
			current.add(i);
			intervals.add(current);
			i++;
		}
		int maxProfit = 0;
		for(List<Integer> subIntervals : intervals) {
			maxProfit += (prices[subIntervals.get(1)] - prices[subIntervals.get(0)]);
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		// daywise stock prices
		int prices[] = {100, 180, 260, 310, 40, 535, 695}; 
		StockBuySellMaximizeProfit s = new StockBuySellMaximizeProfit(); 
        System.out.println("Maximum Profit boso is " +  
                                s.maxProfitBOSO(prices));
        
        System.out.println("Maximum Profit is " +  
                s.maxProfit(prices)); 

	}

}
