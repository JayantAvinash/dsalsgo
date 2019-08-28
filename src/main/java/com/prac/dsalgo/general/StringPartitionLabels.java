package com.prac.dsalgo.general;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/partition-labels/
public class StringPartitionLabels {

	public List<Integer> partitionLabels(String S) {
		int[] last = new int[26];
		for (int i = 0; i < S.length(); ++i)
			last[S.charAt(i) - 'a'] = i;
		int j = 0, anchor = 0;
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < S.length(); ++i) {
			j = Math.max(j, last[S.charAt(i) - 'a']);
			if (i == j) {
				ans.add(i - anchor + 1);
				anchor = i + 1;
			}
			if (j == S.length() - 1 && anchor != S.length()) {
				ans.add(S.length() - anchor);
				break;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		StringPartitionLabels s = new StringPartitionLabels();
		List<Integer> l = s.partitionLabels("ababcbacadefegdehijhklij");
		System.out.println(l.toString());
	}

}
