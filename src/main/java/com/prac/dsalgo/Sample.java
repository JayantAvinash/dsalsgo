package com.prac.dsalgo;

public class Sample {

	public String longestPalindrome(String s) {
        if(s == null) {
            return s;
        }
        int length = s.length();
        if(length < 2) {
            return s;
        }
        int [][]subSeqLength = new int[length][length];
        for(int i = 0; i < length; i++) {
            subSeqLength[i][i] = 1;
        }
        int startIndex = 0;
        int maxLength = 1;
        for(int len = 2; len <= length; len++) {
            for(int i = 0; i <= length - len;i++) {
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j)) {
                    subSeqLength[i][j] = 2 + subSeqLength[i + 1][j - 1];
                } else {
                    subSeqLength[i][j] = Math.max(subSeqLength[i + 1][j], subSeqLength[i][j - 1]);
                }
                if(subSeqLength[i][j] > maxLength) {
                    maxLength = subSeqLength[i][j];
                    startIndex = i;
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }
	public static void main(String[] args) {
		Sample s = new Sample();
		System.out.println(s.longestPalindrome("abcda"));
	}

}