package com.prac.dsalgo.dp;

//https://www.hackerrank.com/challenges/abbr/problem
public class Abbreviation {
	
	static boolean abbreviation(String a, String b) {
        return abbreviation(a, b, a.length() - 1, b.length() - 1);
    }

	private static boolean abbreviation(String a, String b, int i, int j) {
		if(j > i) {
			return false;
		}
		if(j < 0) {
			while(i >= 0) {
				if(a.charAt(i) >= 65 && a.charAt(i) <= 90) {
					return false;
				}
				i--;
			}
			return true;
		}
		if(a.charAt(i) == b.charAt(j)) {
			return abbreviation(a, b, i - 1, j - 1);
		} else if(a.charAt(i) - b.charAt(j) == 32) {
			return (abbreviation(a, b, i - 1, j - 1) || abbreviation(a, b, i - 1, j));
		} else {
			if(a.charAt(i) >= 65 && a.charAt(i) <= 90) {
				return false;
			}
			return abbreviation(a, b, i - 1, j);
		}
	}
	
	static boolean abbreviationDP(String a, String b) {
        int l1 = a.length();
        int l2 = b.length();
        boolean dp[][] = new boolean[l1 + 1][l2 + 1];
        for(int i = 0; i <= l1; i++) {
        	for(int j = 0; j <= i && j <= l2; j++) {
        		if(j == 0) {
        			if(i == 0) {
        				dp[i][j] = true;
        			} else if(a.charAt(i - 1) >= 97 && a.charAt(i - 1) <= 122) {
        				dp[i][j] = dp[i - 1][j];
        			}
        		} else {
        			if(a.charAt(i - 1) == b.charAt(j - 1)) {
        				dp[i][j] = dp[i - 1][j - 1];
        			} else if(a.charAt(i - 1) - b.charAt(j - 1) == 32) {
        				dp[i][j] = dp[i - 1][j - 1] || dp[i - 1][j];
        			} else {
        				if(a.charAt(i - 1) >= 97 && a.charAt(i - 1) <= 122) {
        					dp[i][j] = dp[i - 1][j];
        				}
        			}
        		} 
        		System.out.println("dp[" + i + "][" + j + "]=" + dp[i][j]);
        	}
        }
        return dp[l1][l2];
    }

	public static void main(String[] args) {
	
		String s1 = "daBcd";
		String s2 = "ABC";
		System.out.println(Abbreviation.abbreviation(s1, s2));
	}

}
