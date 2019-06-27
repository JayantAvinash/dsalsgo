package com.prac.dsalgo.dp;

import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubSequenceArray {
	
	public int getMaxSubSequenceLength(final List<Integer> elements) {
		int size = elements.size();
		int []dp = new int[size];
		int overallMax = 0;
		for(int i = 0; i < size; i++) {
			int max = 1;
			for(int j = 0; j < i; j++) {
				if(elements.get(i) > elements.get(j)) {
					max = Math.max(max,  1 + dp[j]);
				}
			}
			dp[i] = max;
			overallMax = Math.max(overallMax, max);
		}
		return overallMax;
	}

	public static void main(String[] args) {
		Integer arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		LongestIncreasingSubSequenceArray lis = new LongestIncreasingSubSequenceArray();
		System.out.println(lis.getMaxSubSequenceLength(Arrays.asList(arr)));

	}

}
