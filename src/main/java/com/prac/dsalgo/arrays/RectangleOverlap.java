package com.prac.dsalgo.arrays;

// https://leetcode.com/problems/rectangle-overlap/
public class RectangleOverlap {
	
	// max (x, y) of both rectangles i.e. (the right top vertex) should be greater than min (x, y) of both rectangles (left bottom vertex)
	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
		return rec1[2] > rec2[0] && rec1[3] > rec2[1] && rec2[2] > rec1[0] && rec2[3] > rec1[1];
	}

	public static void main(String[] args) {
		RectangleOverlap r = new RectangleOverlap();
		int[] arr1 = { 0, 0, 2, 2 };
		int[] arr2 = { 1, 1, 3, 3 };
		System.out.println(r.isRectangleOverlap(arr1, arr2));

	}

}
