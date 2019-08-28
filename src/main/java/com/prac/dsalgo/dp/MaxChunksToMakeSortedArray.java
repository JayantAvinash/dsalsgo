package com.prac.dsalgo.dp;

//https://leetcode.com/problems/max-chunks-to-make-sorted/
public class MaxChunksToMakeSortedArray {

	public int maxChunksToSorted(int[] arr) {
		int maxSoFar = -1;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			maxSoFar = Math.max(maxSoFar, arr[i]);
			if (maxSoFar == i) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		MaxChunksToMakeSortedArray m = new MaxChunksToMakeSortedArray();
		int[] arr = { 1, 0, 2, 3, 4 };
		System.out.println(m.maxChunksToSorted(arr));
	}

}
