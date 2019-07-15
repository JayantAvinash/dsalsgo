package com.prac.dsalgo.dsalgo;

// https://leetcode.com/problems/unique-binary-search-trees/
public class UniqueBSTs {

	public int numTrees(int n) {
		if (n < 0) {
			return 0;
		}
		if (n <= 1) {
			return 1;
		}
		int[] num = new int[n + 1];
		num[0] = 1;
		num[1] = 1;
		num[2] = 2;
		for (int i = 3; i <= n; i++) {
			int t = 0;
			for (int j = 1; j <= i; j++) {
				t += num[j - 1] * num[i - j];
			}
			num[i] = t;
		}
		return num[n];
	}

	public int numTreesV2(int n) {
		if (n < 0) {
			return 0;
		}
		if (n <= 1) {
			return 1;
		}
		int[] num = new int[n + 1];
		num[0] = 1;
		num[1] = 1;
		num[2] = 2;
		for (int i = 3; i <= n; i++) {
			int t = 0;
			int max = (i % 2 == 0) ? i / 2 : (i / 2 + 1);
			for (int j = 1; j <= max; j++) {
				int k = ((j - 1) == (i - j) ? 1 : 2);
				t += k * num[j - 1] * num[i - j];
			}
			num[i] = t;
		}
		return num[n];
	}

	public static void main(String[] args) {
		UniqueBSTs u = new UniqueBSTs();
		System.out.println(u.numTrees(5));
		double j = Math.ceil(3 / 2);
		System.out.println(j);
	}

}
