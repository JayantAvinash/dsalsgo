package com.prac.dsalgo.dp;

import java.util.Scanner;

public class UnboundedKnapsack {

	static int unboundedKnapsack(int k, int[] arr) {
		int[] dp = new int[k + 1];
		for (int i = 1; i <= k; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i >= arr[j]) {
					dp[i] = Math.max(dp[i], dp[i - arr[j]] + arr[j]);
				}
			}
		}
		return dp[k];

	}

	private static final Scanner scanner = new Scanner(System.in);

	/*
	 * 2 
	 * 3 12
	 *  1 6 9
	 *   5 9
	 *   3 4 4 4 8
	 */
	public static void main(String[] args) {

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		for (int x = 0; x < t; x++) {
			String[] nk = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nk[0]);

			int k = Integer.parseInt(nk[1]);

			int[] arr = new int[n];

			String[] arrItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int arrItem = Integer.parseInt(arrItems[i]);
				arr[i] = arrItem;
			}

			int result = unboundedKnapsack(k, arr);

			System.out.println(result);
		}

		scanner.close();
	}

}
