package com.prac.dsalgo.arrays;

// https://leetcode.com/problems/remove-k-digits/
public class RemoveKDigits {

	public String removeKdigits(String num, int k) {
		if (num == null || k <= 0) {
			return num;
		}
		if (num.length() <= k) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		sb = removeKDigits(num, 0, k, sb);
		return (sb.length() == 0 ? "0" : sb.toString());
	}

	public StringBuilder removeKDigits(String s, int start, int k, StringBuilder sb) {
		if (s.length() - start <= k) {
			return sb;
		}
		int minIndex = -1;
		int min = 10;
		for (int i = start; i <= start + k; i++) {
			int c = s.charAt(i) - '0';
			if (c < min) {
				minIndex = i;
				min = c;
			}
		}
		if (min > 0 || sb.length() > 0) {
			sb.append(s.charAt(minIndex));
		}

		removeKDigits(s, minIndex + 1, k - (minIndex - start), sb);
		return sb;
	}

	public static void main(String[] args) {
		RemoveKDigits r = new RemoveKDigits();
		System.out.println(r.removeKdigits("1432219", 3));

	}

}
