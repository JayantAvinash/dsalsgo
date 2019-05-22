package com.prac.dsalgo.dp;

public class Knapsack {

	public int getMaxKnapsackValue(int capacity, int[] wt, int[] val, int n) {
		if (capacity <= 0 || n <= 0) {
			return 0;
		}
		return Math.max(val[n - 1] + getMaxKnapsackValue(capacity - wt[n - 1], wt, val, n - 1),
				getMaxKnapsackValue(capacity, wt, val, n - 1));
	}
	
	public int getMaxKnapsackValueDP(int capacity, int[] wt, int[] val, int n) {
		int [][]knap = new int[n + 1][capacity + 1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= capacity; j++) {
				if(wt[i - 1] > j) {
					knap[i][j] = knap[i - 1][j];
				} else {
					knap[i][j] = Math.max(val[i - 1] + knap[i - 1][j - wt[i - 1]], knap[i - 1][j]);
				}
			}
		}
		return knap[n][capacity];
	}

	public static void main(String args[]) {
		int val[] = new int[] { 60, 130, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		//int W = 50;
		int n = val.length;
		Knapsack k = new Knapsack();
		for(int W= 0; W <= 61; W++) {
			System.out.println("W is " + W);
			System.out.println(k.getMaxKnapsackValueDP(W, wt, val, n));
			System.out.println(k.getMaxKnapsackValueDP(W, wt, val, n));
			System.out.println();
		}
		
	}
}
