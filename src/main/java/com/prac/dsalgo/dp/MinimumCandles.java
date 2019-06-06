package com.prac.dsalgo.dp;

//https://leetcode.com/problems/candy/
public class MinimumCandles {
	
	static long candies(int n, int[] arr) {
		long []dp = new long[n];
        for(int i = 0; i < n - 1; i++) {
            if(arr[i] < arr[i + 1]) {
                dp[i + 1] = dp[i] + 1;
            } 
        }
        for(int i = n - 1; i > 0; i--) {
            if(arr[i - 1] > arr[i]) {
                dp[i - 1] = Math.max(dp[i - 1], dp[i] + 1);
            }
        }
        long count = 0;
        for(int i = 0; i < n; i++) {
            count += dp[i];
        }
        return count + n;
    }

	public static void main(String[] args) {
		int []arr = {2,4,3,5,2,6,4,5};
		System.out.println(MinimumCandles.candies(arr.length, arr));
	}

}
