package com.prac.dsalgo.arrays;

// https://leetcode.com/problems/sort-colors/
public class SortColors {

	public void sortColors(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int low = 0, high = nums.length - 1, mid = 0, temp = 0;
		while (mid <= high) {
			switch (nums[mid]) {
			case 0:
				temp = nums[low];
				nums[low] = nums[mid];
				nums[mid] = temp;
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				temp = nums[high];
				nums[high] = nums[mid];
				nums[mid] = temp;
				high--;
				break;
			}
		}
	}

	public static void main(String[] args) {
		SortColors sc = new SortColors();
		int[] nums = { 2, 0, 2, 1, 1, 0 };
		sc.sortColors(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

}
