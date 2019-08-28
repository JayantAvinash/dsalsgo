package com.prac.dsalgo.general;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/custom-sort-string/
public class CustomSortString {
	
	// O(nlogn)
	public String customSortString(String S, String T) {
		if (S == null || S.isEmpty() || T == null || T.isEmpty()) {
			return T;
		}
		Map<Character, Integer> charRank = new HashMap<>();
		for (int i = 0; i < S.length(); i++) {
			charRank.put(S.charAt(i), i);
		}
		PriorityQueue<Character> p = new PriorityQueue<Character>(new Comparator<Character>() {

			@Override
			public int compare(Character c1, Character c2) {
				if (charRank.containsKey(c2)) {
					if (charRank.containsKey(c1)) {
						return charRank.get(c1) - charRank.get(c2);
					} else {
						return 1;
					}
				}
				return -1;
			}
		});
		for (char c : T.toCharArray()) {
			p.add(c);
		}
		StringBuilder sb = new StringBuilder();
		while (!p.isEmpty()) {
			sb.append(p.poll());
		}
		return sb.toString();
	}
	
	
	//O(n)
	public String customSortStringFaster(String order, String toSort) {
		if (toSort == null || toSort.isEmpty() || order.isEmpty())
			return toSort;

		// counter
		int count[] = new int[26];

		// Find the occurrence of each char in "toSort" string
		for (int i = 0; i < toSort.length(); i++)
			count[toSort.charAt(i) - 'a']++;

		StringBuilder sorted = new StringBuilder();

		for (char c : order.toCharArray()) {

			while (count[c - 'a'] > 0) {
				sorted.append(c);
				count[c - 'a']--;
			}
		}

		for (int i = 0; i < count.length; i++) {
			while (count[i] > 0) {
				sorted.append((char) (i + 'a'));
				count[i]--;
			}
		}

		return sorted.toString();
	}

	public static void main(String[] args) {
		String S = "cba";
		String T = "abcd";
		CustomSortString c = new CustomSortString();
		System.out.println(c.customSortString(S, T));
		System.out.println(c.customSortStringFaster(S, T));
	}

}
