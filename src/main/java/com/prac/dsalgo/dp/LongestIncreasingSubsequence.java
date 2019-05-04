package com.prac.dsalgo.dp;

public class LongestIncreasingSubsequence {
	int overallMax;
	
	int getMaxSubsequencelength(int []arr, int n) {
		int maxlength = 1;
		for(int i = 0; i < n; i++) {
			if(arr[n - 1] > arr[i]) {
				maxlength = Math.max(maxlength, 1 + getMaxSubsequencelength(arr, i));
			}
		}
		if(maxlength > overallMax) {
			overallMax = maxlength;
		}
		return maxlength;
	}
	
	int getMaxSubsequencelengthDP(int []arr) {
		int []maxlength = new int[arr.length];
		maxlength[0] = 1;
		for(int i = 1; i < arr.length; i++) {
			int max = 1;
			for(int j = 0; j < i;j++) {
				if(arr[i]  > arr[j]) {
					max = Math.max(max, 1 + maxlength[j]);
				}
			}
			maxlength[i] = max;
		}
		int maxima = 0;
		for(int i = 0; i < arr.length; i++) {
			maxima = Math.max(maxima, maxlength[i]);
		}
		return maxima;
	}
	
	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		lis.overallMax = 1;
		lis.getMaxSubsequencelength(arr, arr.length);
		System.out.println(lis.overallMax);
		System.out.println(lis.getMaxSubsequencelengthDP(arr));
	}

}
