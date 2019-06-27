package com.prac.dsalgo.dp;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringDistinctChars {

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		Map<Character, Integer> charIndexMap = new HashMap<>();
		int max = 0;
		int l = s.length();
		int start = 0;
		for (int i = 0; i < l; i++) {
			if (charIndexMap.containsKey(s.charAt(i))) {
				start = Math.max(start, charIndexMap.get(s.charAt(i)) + 1);
			}
			charIndexMap.put(s.charAt(i), i);
			max = Math.max(max, i - start + 1);
		}
		return max;
	}

	public static void main(String[] args) {
		LongestSubstringDistinctChars l = new LongestSubstringDistinctChars();
		System.out.println(l.lengthOfLongestSubstring("pwwkew"));
	}

}
