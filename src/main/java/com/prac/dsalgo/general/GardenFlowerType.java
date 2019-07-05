package com.prac.dsalgo.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/flower-planting-with-no-adjacent/
public class GardenFlowerType {

	public int[] gardenNoAdj(int N, int[][] paths) {
		Map<Integer, Set<Integer>> connectedGardens = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			connectedGardens.put(i, new HashSet<>());
		}
		for (int[] path : paths) {
			connectedGardens.get(path[0]).add(path[1]);
			connectedGardens.get(path[1]).add(path[0]);
		}
		int[] types = new int[N];
		for (int i = 1; i <= N; i++) {
			List<Integer> colors = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
			for (int j : connectedGardens.get(i)) {
				Integer type = types[j - 1];
				colors.remove(type);
			}
			types[i - 1] = colors.get(0);
		}
		return types;
	}

	public static void main(String[] args) {
		GardenFlowerType gft = new GardenFlowerType();
		int[][] paths = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 1 }, { 1, 3 }, { 2, 4 } };
		int[] types = gft.gardenNoAdj(4, paths);
		for (int type : types) {
			System.out.print(type + " ");
		}
	}

}
