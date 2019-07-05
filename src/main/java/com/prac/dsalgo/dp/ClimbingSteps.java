package com.prac.dsalgo.dp;

// https://leetcode.com/problems/climbing-stairs/
public class ClimbingSteps {

	public int climbStairsDP(int n) {
		if (n <= 0) {
			return 0;
		}
		int[] steps = new int[n + 1];
		steps[0] = steps[1] = 1;
		for (int i = 2; i <= n; i++) {
			steps[i] = steps[i - 1] + steps[i - 2];
		}
		return steps[n];
	}

	public int climbStairs(int n) {
		if (n <= 0) {
			return 0;
		}
		int j = 1, k = 1;
		for (int i = 2; i <= n; i++) {
			int temp = k;
			k += j;
			j = temp;
		}
		return k;
	}

	public static void main(String[] args) {
		ClimbingSteps c = new ClimbingSteps();
		System.out.println(c.climbStairs(5));
		System.out.println(c.climbStairsDP(5));
	}

}
