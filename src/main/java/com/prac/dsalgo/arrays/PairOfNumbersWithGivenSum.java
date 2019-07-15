package com.prac.dsalgo.arrays;

import java.util.HashMap;
import java.util.Map;

public class PairOfNumbersWithGivenSum {

	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			return null;
		}
		Map<Integer, Integer> s = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (s.containsKey(target - nums[i])) {
				int[] arr = new int[2];
				arr[0] = s.get(target - nums[i]);
				arr[1] = i;
				return arr;
			} else {
				s.put(nums[i], i);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		PairOfNumbersWithGivenSum p = new PairOfNumbersWithGivenSum();
		int[] nums = { 2, 7, 11, 15 };
		int []temp = nums;
		temp[0] = 1;
		System.out.println(nums[0]);
		System.out.println(p.twoSum(nums, 9));
	}

}
