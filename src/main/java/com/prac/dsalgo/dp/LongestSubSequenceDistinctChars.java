package com.prac.dsalgo.dp;

import java.util.HashSet;
import java.util.Set;

public class LongestSubSequenceDistinctChars {

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int l = s.length();
		CharLength[][] arr = new CharLength[l + 1][l + 1];
		for (int i = 0; i < l; i++) {
			CharLength c = new CharLength();
			c.length = 1;
			c.chars = new HashSet<>();
			c.chars.add(s.charAt(i));
			arr[i][i + 1] = c;
		}
		for (int total = 2; total <= l; total++) {
			for (int i = 0; i < l - total + 1; i++) {
				int j = i + total;
				CharLength c = new CharLength();
				c.chars = new HashSet<>(arr[i][j - 1].chars);
				c.length = arr[i][j - 1].length;
				if (c.chars.add(s.charAt(j - 1))) {
					c.length++;
				}
				arr[i][j] = c;
			}
		}
		return arr[0][l].length;
	}

	class CharLength {
		int length;
		Set<Character> chars;
	}

	public static void main(String[] args) {
		LongestSubSequenceDistinctChars l = new LongestSubSequenceDistinctChars();
		System.out.println(l.lengthOfLongestSubstring("pwwkew"));

	}

}
