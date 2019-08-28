package com.prac.dsalgo.arrays;

//https://leetcode.com/problems/squares-of-a-sorted-array/
public class SortedSquares {

	public int[] sortedSquares(int[] A) {
		int i = -1;
		while (i < A.length - 1 && A[i + 1] < 0) {
			i++;
		}
		int j = i;
		int k = i + 1;
		int[] arr = new int[A.length];
		int l = 0;
		while (j >= 0 && k < A.length) {
			if (A[k] > Math.abs(A[j])) {
				arr[l++] = A[j] * A[j];
				j--;
			} else {
				arr[l++] = A[k] * A[k];
				k++;
			}
		}
		if (j < 0) {
			while (k < A.length) {
				arr[l++] = A[k] * A[k];
				k++;
			}
		} else {
			while (j >= 0) {
				arr[l++] = A[j] * A[j];
				j--;
			}

		}
		return arr;
	}

	public static void main(String[] args) {
		SortedSquares s = new SortedSquares();
		int[] arr = { -7, -3, 2, 3, 11 };
		int[] arr1 = s.sortedSquares(arr);
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}

	}

}
