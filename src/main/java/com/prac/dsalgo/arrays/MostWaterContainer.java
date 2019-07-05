package com.prac.dsalgo.arrays;

public class MostWaterContainer {

	public int maxArea(int[] height) {
		int l = 0, r = height.length - 1;
		int maxArea = 0;
		while (l < r) {
			int min = Math.min(height[l], height[r]);
			int currArea = (r - l) * min;
			maxArea = Math.max(maxArea, currArea);
			if (height[l] < height[r]) {
				l++;
			} else {
				r--;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		MostWaterContainer m = new MostWaterContainer();
		int[] arr = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(m.maxArea(arr));
	}

}
