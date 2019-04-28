package com.prac.dsalgo.general;

/**
 * @author jayant
 * check if first string is subsequence of second
 */
public class SubSequence {
	
	boolean isSubsequence(String str1, String str2) {
		return isSubsequence(str1, str2, str1.length() - 1, str2.length() - 1);
	}

	private boolean isSubsequence(String str1, String str2, int i, int j) {
		if(i == -1) {
			return true;
		}
		if(j == -1) {
			return false;
		}
		if(str1.charAt(i) == str2.charAt(j)) {
			i--;
		}
		j--;
		return isSubsequence(str1, str2, i, j);
	}
	
	public static void main(String[] args) {
        String str1 = "gksrek"; 
        String str2 = "geeksforgeeks";
        SubSequence s = new SubSequence();
        System.out.println(s.isSubsequence(str1, str2));
	}
}
