package com.prac.dsalgo.arrays;

import java.util.Arrays;

//https://leetcode.com/problems/3sum-closest/
public class ThreeSumClosest {

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int closest = Integer.MAX_VALUE;
		boolean positive = true;
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i - 1] == nums[i]) {
				continue;
			}
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				if (nums[i] + nums[j] == target - nums[k]) {
					return target;
				}
				int diff = nums[i] + nums[j] + nums[k] - target;
				closest = Math.min(closest, Math.abs(diff));
				if (closest == Math.abs(diff)) {
					if (diff > 0) {
						positive = true;
					} else {
						positive = false;
					}
				}
				if (diff < 0) {
					j++;
				} else {
					k--;
				}
			}
		}
		return target + (positive ? closest : -closest);
	}

	public static void main(String[] args) {
		ThreeSumClosest t = new ThreeSumClosest();
		int[] nums = { -1, 2, 1, -4 };
		System.out.println(t.threeSumClosest(nums, 1));
	}

}
