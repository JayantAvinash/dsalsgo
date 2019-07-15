package com.prac.dsalgo.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> l = new LinkedList<>();
		if (nums == null || nums.length < 3) {
			return l;
		}
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i - 1] == nums[i]) {
				continue;
			}
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				if (nums[j] + nums[k] == -nums[i]) {
					l.add(Arrays.asList(nums[i], nums[j], nums[k]));
					while (nums[j] == nums[j + 1] && j < nums.length - 2) {
						j++;
					}
					while (nums[k] == nums[k - 1] && k > 1) {
						k--;
					}
					k--;
					j++;
				} else if (nums[j] + nums[k] > -nums[i]) {
					k--;
				} else {
					j++;
				}
			}
		}
		return l;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		ThreeSum t = new ThreeSum();
		System.out.println(t.threeSum(nums));
	}

}
