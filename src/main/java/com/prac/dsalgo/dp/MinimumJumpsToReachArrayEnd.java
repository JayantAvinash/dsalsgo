package com.prac.dsalgo.dp;

import java.util.Arrays;

public class MinimumJumpsToReachArrayEnd {

	public int getMinJumps(int[] arr) {
		int n = arr.length;
		int jumps[] = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			jumps[i] = Integer.MAX_VALUE;
		}
		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] <= 0) {
				continue;
			}
			if (arr[i] + i >= n - 1) {
				jumps[i] = 1;
				continue;
			}

			for (int j = 1; j <= arr[i]; j++) {
				if (jumps[j + i] != Integer.MAX_VALUE) {
					jumps[i] = Math.min(jumps[i], 1 + jumps[j + i]);
				}

			}

		}
		return jumps[0];
	}

	public int jump(int[] nums) {
		int length = nums.length;
		if (length < 2) {
			return 0;
		}
		int[] jumps = new int[length - 1];
		Arrays.fill(jumps, Integer.MAX_VALUE);
		jumps[0] = 0;
		for (int i = 0; i < length - 2; i++) {
			if (nums[i] <= 0) {
				continue;
			}
			if (nums[i] + i >= length - 1) {
				return jumps[i] + 1;
			}
			for (int j = 1; j <= nums[i]; j++) {
				jumps[i + j] = Math.min(jumps[i + j], 1 + jumps[i]);
			}
		}
		return Integer.MAX_VALUE;
	}

	public int jumpGreedy(int[] A) {
		int jumps = 0, curEnd = 0, curFarthest = 0;
		for (int i = 0; i < A.length - 1; i++) {
			curFarthest = Math.max(curFarthest, i + A[i]);
			if (i == curEnd) {
				jumps++;
				curEnd = curFarthest;
				if (curFarthest >= A.length - 1) {
					return jumps;
				}
			}
		}
		return jumps;
	}

	public int getMinJumpsRecursive(int[] arr, int from) {
		if (arr[from] <= 0) {
			return Integer.MAX_VALUE;
		}
		if (from + arr[from] >= arr.length - 1) {
			return 1;
		}
		int min = Integer.MAX_VALUE;
		for (int i = from + 1; i <= from + arr[from]; i++) {
			int jumps = getMinJumpsRecursive(arr, from + i);
			if (jumps != Integer.MAX_VALUE) {
				min = Math.min(min, 1 + jumps);
			}
		}
		return min;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 8, 0, 0, 6, 7, 6, 8, 9 };
		MinimumJumpsToReachArrayEnd m = new MinimumJumpsToReachArrayEnd();
		System.out.println(m.jumpGreedy(arr));
		System.out.println(m.getMinJumpsRecursive(arr, 0));
	}
}
