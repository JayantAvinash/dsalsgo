package com.prac.dsalgo.dp;

import java.util.List;

//https://leetcode.com/problems/triangle/
public class TriangleMinSum {

	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}
		for (int i = triangle.size() - 2; i >= 0; i--) {
			List<Integer> current = triangle.get(i);
			List<Integer> prev = triangle.get(i + 1);
			for (int j = 0; j < current.size(); j++) {
				current.set(j, current.get(j) + Math.min(prev.get(j), prev.get(j + 1)));
			}
		}
		return triangle.get(0).get(0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
