package com.prac.dsalgo.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSubsequence {

	// O(2n) but faster in leetcode as involves less operations
	public int getMaxSubSequenceLength(int[] arr) {
		int l = arr.length;
		if (l < 2) {
			return l;
		}
		Set<Integer> elements = new HashSet<>();
		for (int i = 0; i < l; i++) {
			elements.add(arr[i]);
		}
		int maxLength = 0;
		for (int i = 0; i < l; i++) {
			if (!elements.contains(arr[i] - 1)) {
				int j = arr[i];
				while (elements.contains(j)) {
					j++;
				}
				maxLength = Math.max(maxLength, j - arr[i]);
			}
		}
		return maxLength;
	}

	// O(n)
	public int longestConsecutive(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}
		Map<Integer, Integer> s = new HashMap<>();
		int maxLength = 0;
		for (int i = 0; i < nums.length; i++) {
			if (!s.containsKey(nums[i])) {
				int left = s.containsKey(nums[i] - 1) ? s.get(nums[i] - 1) : 0;
				int right = s.containsKey(nums[i] + 1) ? s.get(nums[i] + 1) : 0;
				int length = 1 + left + right;
				maxLength = Math.max(maxLength, length);
				s.put(nums[i], length);
				// setting lengths of extremes correctly;middle ones are already
				// used, so doesn't matter if we don't correct them
				s.put(nums[i] - left, length);
				s.put(nums[i] + right, length);

			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		int arr[] = { 200, 100, 4, 3, 10, 7, 5, 8, 2 };
		LongestConsecutiveSubsequence l = new LongestConsecutiveSubsequence();
		System.out.println(l.getMaxSubSequenceLength(arr));
	}

}
