package com.prac.dsalgo.dp;

public class LongestCommonSubsequence {
	
	public int getMaxSubsequenceLengthRecursive(String s1, String s2, int m, int n) {
		if(m == 0 || n == 0) {
			return 0;
		}
		if(s1.charAt(m -1) == s2.charAt(n - 1)) {
			return 1 + getMaxSubsequenceLengthRecursive(s1, s2, m - 1, n - 1);
		}
		return Math.max(getMaxSubsequenceLengthRecursive(s1,  s2, m -1 , n), getMaxSubsequenceLengthRecursive(s1, s2, m , n - 1));
	}
	
	public int getLongestSubsequenceDP(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		int [][]length = new int[l1 + 1][l2 + 1];
		for(int i = 1; i <= l1; i++) {
			for(int j = 1; j <= l2; j++) {
				if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
					length[i][j] = 1 + length[i - 1][j - 1];
				}
				else {
					length[i][j] = Math.max(length[i-1][j], length[i][j - 1]);
				}
			}
		}
		return length[l1][l2];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCommonSubsequence lcs = new LongestCommonSubsequence(); 
	    String s1 = "AGGTAB"; 
	    String s2 = "GXTXAYB";
	    System.out.println(lcs.getMaxSubsequenceLengthRecursive(s1, s2, s1.length(), s2.length()));
	    System.out.println(lcs.getLongestSubsequenceDP(s1, s2));

	}

}
