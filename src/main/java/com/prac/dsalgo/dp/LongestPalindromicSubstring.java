package com.prac.dsalgo.dp;

public class LongestPalindromicSubstring {
	
	String getLongestPalindromicSubstring(String str) {
		int n = str.length();
		if(n == 0) {
			return "";
		}
		boolean [][]palindrome = new boolean[n][n];
		int maxlength = 1, start = 0;
		for(int i = 0; i < n; i++) {
			palindrome[i][i] = true;
			if(i < n - 1 && str.charAt(i) == str.charAt(i + 1)) {
				palindrome[i][i + 1] = true;
				start = i;
				maxlength = 2;
			}
		}
		// total is total length of string
		for(int total = 3; total <=n; total++) {
			for(int i = 0; i < n - total + 1; i++) {
				int j = i + total - 1;
				if(str.charAt(i) == str.charAt(j) && palindrome[i + 1][j - 1]) {
					palindrome[i][j] = true;
					if(total > maxlength) {
						start = i;
						maxlength = total;
					}
				}
			}
		}
		return str.substring(start, start + maxlength);
	}

	public static void main(String[] args) {
		String str = "";
		LongestPalindromicSubstring l = new LongestPalindromicSubstring();
		System.out.println("Longest substring is: " + l.getLongestPalindromicSubstring(str));
	}
}
