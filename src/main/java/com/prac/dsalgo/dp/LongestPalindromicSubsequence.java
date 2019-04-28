package com.prac.dsalgo.dp;

public class LongestPalindromicSubsequence {
	
	int getLongestpalindromicSubsequenceLengthRecursive(String str, int i, int j) {
		if(i >= j) {
			return 1;
		}
		if(str.charAt(i) == str.charAt(j)) {
			return 2 + getLongestpalindromicSubsequenceLengthRecursive(str, i + 1, j - 1);
		}
		return Math.max(getLongestpalindromicSubsequenceLengthRecursive(str, i + 1, j), getLongestpalindromicSubsequenceLengthRecursive(str, i, j - 1));
	}
	
	int getLongestpalindromicSubsequenceLengthDP(String str) {
		int n = str.length();
		int [][]length = new int[n][n];
		for(int i = 0; i < n; i++ ) {
			length[i][i] = 1;
		}
		
		//cl is length of subsequence
		//calculating palindromic subsequence length wise
		// only calculating half matrix; upper diagonal; j > i
		for(int cl = 2; cl <= n; cl++) {
			for(int i = 0; i < n - cl + 1; i++) {
				int j = i + cl - 1;
				if(str.charAt(i) == str.charAt(j)) {
					length[i][j] = 2 + length[i + 1][j - 1];
				} else {
					length[i][j] = Math.max(length[i + 1][j], length[i][j - 1]);
				}
				length[j][i] = length[i][j];
			}
		}
		return length[0][n - 1];
	}
	
	public static void main(String[] args) {
		String seq = "GEEKSFORGEEKS";
		LongestPalindromicSubsequence l = new LongestPalindromicSubsequence();
		System.out.println(l.getLongestpalindromicSubsequenceLengthRecursive(seq, 0, seq.length() - 1));
		System.out.println(l.getLongestpalindromicSubsequenceLengthDP(seq));
	}

}
