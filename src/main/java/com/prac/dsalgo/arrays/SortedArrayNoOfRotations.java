package com.prac.dsalgo.arrays;

//no of rotations is equal to no of elements moved to the last
public class SortedArrayNoOfRotations {
	
	public int countRotations(int []arr, int start, int end) {
		if(end <= start) {
			return 0;
		}
		int mid = (start + end)/2;
		if(mid < end && arr[mid] > arr[mid + 1]) {
			return arr.length - (mid + 1);
		} else if(mid > start && arr[mid] < arr[mid - 1]) {
			return arr.length - mid;
		}
		int lRotation = countRotations(arr, mid + 1, end);
		if(lRotation > 0) {
			return lRotation;
		}
		return countRotations(arr, start, mid - 1);
	}
	
	

	public static void main(String[] args) {
		int arr[] = {15, 18, 2, 3, 6, 12}; 
        int n = arr.length; 
        SortedArrayNoOfRotations s = new SortedArrayNoOfRotations(); 
        System.out.println(s.countRotations(arr, 0, n-1)); 

	}

}
