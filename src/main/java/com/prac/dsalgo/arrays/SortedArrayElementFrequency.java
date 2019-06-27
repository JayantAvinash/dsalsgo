package com.prac.dsalgo.arrays;

public class SortedArrayElementFrequency {
	
	public int getFrequency(int[] arr, int from, int to, int val) {
		if(from > to || val < arr[from] || val > arr[to]) {
			return 0;
		}
		int mid = (from + to)/2;
		if(arr[mid] > val) {
			return getFrequency(arr, from, mid  - 1, val);
		} else if(arr[mid] < val) {
			return getFrequency(arr, mid + 1, to, val);
		} else {
			return 1 + getFrequency(arr, from, mid - 1, val) + getFrequency(arr, mid + 1, to, val);
		}
	}

	public static void main(String[] args) {
		int arr[] = {1, 2, 2, 3, 3, 3, 3, 5, 5}; 
        int to = arr.length - 1;
		SortedArrayElementFrequency s = new SortedArrayElementFrequency();
		System.out.println(s.getFrequency(arr, 0, to, 4));

	}

}
