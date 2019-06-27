package com.prac.dsalgo.general;

// https://leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix {
	
	 public String longestCommonPrefix(String[] strs) {
	        if(strs == null || strs.length == 0) {
	            return "";
	        }
	        int minLength = strs[0].length();
	        int index = 0;
	        for(int i = 1; i < strs.length; i++) {
	            if(strs[i].length() < minLength) {
	                minLength = strs[i]. length();
	                index = i;
	            }
	        }
	        if(minLength == 0) {
	            return "";
	        }
	        String temp = strs[index];
	        strs[index] = strs[0];
	        strs[0] = temp;
	        for(int i = 1; i < strs.length; i++) {
	            while(strs[i].indexOf(temp) != 0) {
	                temp = temp.substring(0, temp.length() - 1);
	                if("".equals(temp)) {
	                    return "";
	                }
	            }
	        }
	        return temp;
	    }

	public static void main(String[] args) {
		LongestCommonPrefix l = new LongestCommonPrefix();
		String []strs = {"flower","flow","flight"};
		System.out.println(l.longestCommonPrefix(strs));
	}

}
