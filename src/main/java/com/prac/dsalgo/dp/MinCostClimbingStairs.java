package com.prac.dsalgo.dp;

// https://leetcode.com/problems/min-cost-climbing-stairs/
public class MinCostClimbingStairs {

	public int minCostClimbingStairs(int[] cost) {
		if (cost == null || cost.length < 2) {
			return 0;
		}
		int l = cost.length;
		int first = cost[l - 1];
		int second = cost[l - 2];
		for (int i = l - 3; i >= 0; i--) {
			int temp = first;
			first = second;
			second = cost[i] + Math.min(temp, second);
		}
		return Math.min(first, second);
	}

	public int minCostClimbingStairsDP(int[] cost) {
		if (cost == null || cost.length < 2) {
			return 0;
		}
		int l = cost.length;
		int[] min = new int[l];
		min[l - 1] = cost[l - 1];
		min[l - 2] = cost[l - 2];
		for (int i = l - 3; i >= 0; i--) {
			min[i] = cost[i] + Math.min(min[i + 1], min[i + 2]);
		}
		return Math.min(min[0], min[1]);
	}

	public static void main(String[] args) {
		MinCostClimbingStairs m = new MinCostClimbingStairs();
		int[] arr = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
		System.out.println(m.minCostClimbingStairs(arr));
	}

}
