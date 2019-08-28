package com.prac.dsalgo.arrays;

import java.util.PriorityQueue;

// https://leetcode.com/problems/relative-sort-array/
public class RelativeSortArray {

	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		if (arr2.length == 0) {
			return arr1;
		}
		int k = 0;
		for (int i = 0; i < arr2.length; i++) {
			for (int j = k; j < arr1.length; j++) {
				if (arr1[j] == arr2[i]) {
					int temp = arr1[k];
					arr1[k] = arr1[j];
					arr1[j] = temp;
					k++;
				}
			}
		}
		if (k <= arr1.length) {
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for (int i = k; i < arr1.length; i++) {
				pq.offer(arr1[i]);
			}
			for (int i = k; i < arr1.length; i++) {
				arr1[i] = pq.poll();
			}
		}
		return arr1;
	}

	public static void main(String[] args) {
		RelativeSortArray r = new RelativeSortArray();
		int[] arr1 = { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 };
		int[] arr2 = { 2, 1, 4, 3, 9, 6 };
		r.relativeSortArray(arr1, arr2);
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
	}

}
