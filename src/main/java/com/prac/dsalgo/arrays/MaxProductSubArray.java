package com.prac.dsalgo.arrays;

// https://leetcode.com/problems/maximum-product-subarray/
public class MaxProductSubArray {

	public int maxProduct(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		int currentMin = 1;
		int max = 0;
		int currentMax = 1;
		int maxVal = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			maxVal = Math.max(maxVal, nums[i]);
			boolean flag = false;
			if (nums[i] > 0) {
				flag = true;
				currentMax = nums[i] * currentMax;
				currentMin = Math.min(currentMin * nums[i], 1);
			} else if (nums[i] == 0) {
				currentMax = 1;
				currentMin = 1;
			} else {
				int temp = currentMax;
				if (currentMin < 1) {
					currentMax = nums[i] * currentMin;
					flag = true;
				} else {
					currentMax = 1;
				}
				currentMin = temp * nums[i];
			}
			if (flag) {
				max = Math.max(currentMax, max);
			}

		}
		return max == 0 ? maxVal : max;
	}

	public int maxProductAlternate(int[] A) {
		if (A.length == 0) {
			return 0;
		}

		int maxherepre = A[0];
		int minherepre = A[0];
		int maxsofar = A[0];
		int maxhere, minhere;

		for (int i = 1; i < A.length; i++) {
			maxhere = Math.max(Math.max(maxherepre * A[i], minherepre * A[i]), A[i]);
			minhere = Math.min(Math.min(maxherepre * A[i], minherepre * A[i]), A[i]);
			maxsofar = Math.max(maxhere, maxsofar);
			maxherepre = maxhere;
			minherepre = minhere;
		}
		return maxsofar;
	}

	public static void main(String[] args) {
		MaxProductSubArray m = new MaxProductSubArray();
		int[] arr = { 2, 3, -2, 4 };
		System.out.println(m.maxProduct(arr));
	}

}
