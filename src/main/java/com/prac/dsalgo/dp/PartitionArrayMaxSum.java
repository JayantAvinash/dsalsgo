package com.prac.dsalgo.dp;

import java.util.Date;

// https://leetcode.com/problems/partition-array-for-maximum-sum/
public class PartitionArrayMaxSum {

	public int maxSumAfterPartitioning(int[] A, int K) {
		int l = A.length;
		int[] maxSum = new int[l];
		for (int i = l - 1; i >= 0; i--) {
			int max = 0;
			int maximum = 0;
			int j = 0;
			int current = i;
			while (j < K && current < l) {
				maximum = Math.max(maximum, A[current]);
				current++;
				j++;
				max = Math.max(max, j * maximum + (current < l ? maxSum[current] : 0));
			}
			maxSum[i] = max;
		}
		return maxSum[0];
	}

	public int maxSumAfterPartitioningRecursive(int[] A, int K) {
		return maxSumAfterPartitioning(A, K, 0);
	}

	private int maxSumAfterPartitioning(int[] A, int K, int from) {
		if (from >= A.length) {
			return 0;
		}
		int max = 0;
		int maximum = 0;
		int i = 0;
		while (i < K && from < A.length) {
			maximum = Math.max(maximum, A[from]);
			from++;
			i++;
			max = Math.max(max, i * maximum + maxSumAfterPartitioning(A, K, from));
		}
		return max;
	}

	public static void main(String[] args) {
		PartitionArrayMaxSum p = new PartitionArrayMaxSum();
		int[] arr = { 20779, 436849, 274670, 543359, 569973, 280711, 252931, 424084, 361618, 430777, 136519, 749292,
				933277, 477067, 502755, 695743, 413274, 168693, 368216, 677201, 198089, 927218, 633399, 427645, 317246,
				403380, 908594, 854847, 157024, 719715, 336407, 933488, 599856, 948361, 765131, 335089, 522119, 403981,
				866323, 519161, 109154, 349141, 764950, 558613, 692211 };
		long start = new Date().getTime();
		System.out.println(p.maxSumAfterPartitioning(arr, 2));
		System.out.println(new Date().getTime() - start);
		start = new Date().getTime();
		System.out.println(p.maxSumAfterPartitioningRecursive(arr, 2));
		System.out.println(new Date().getTime() - start);

		System.out.println(p.maxSumAfterPartitioning(arr, 40));
	}

}
