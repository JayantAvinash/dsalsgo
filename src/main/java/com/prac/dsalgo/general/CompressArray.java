package com.prac.dsalgo.general;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/discuss/interview-question/326564/google-onsite-interview-compress-2d-array
public class CompressArray {

	public void compressArray(int[][] arr) {
		int r = arr.length, c = arr[0].length;
		PriorityQueue<Integer> p = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				return arr[a / c][a % c] - arr[b / c][b % c];
			}
		});
		for (int i = 0; i < r * c; i++) {
			p.offer(i);
		}
		int i = 0;
		int prev = Integer.MIN_VALUE;
		while (!p.isEmpty()) {
			int pos = p.poll();
			int x = pos / c, y = pos % c;
			if (prev != arr[x][y]) {
				i++;
			}
			prev = arr[x][y];
			arr[x][y] = i;
		}
	}

	public void compressArrayRowColWise(int[][] arr) {
		int r = arr.length, c = arr[0].length;
		PriorityQueue<Integer> p = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				return arr[a / c][a % c] - arr[b / c][b % c];
			}
		});
		for (int i = 0; i < r * c; i++) {
			p.offer(i);
		}
		int[] rowMax = new int[r], colMax = new int[c], rowPrev = new int[r], colPrev = new int[c];
		Arrays.fill(rowPrev, Integer.MIN_VALUE);
		Arrays.fill(colPrev, Integer.MIN_VALUE);
		while (!p.isEmpty()) {
			int pos = p.poll();
			int x = pos / c, y = pos % c;
			boolean incRow = false;
			if (rowPrev[x] != arr[x][y]) {
				incRow = true;
			}
			rowPrev[x] = arr[x][y];
			boolean incCol = false;
			if (colPrev[y] != arr[x][y]) {
				incCol = true;
			}
			colPrev[y] = arr[x][y];
			if (rowMax[x] > colMax[y]) {
				int i = incRow ? 1 : 0;
				arr[x][y] = rowMax[x] = colMax[y] = rowMax[x] + i;

			} else if (rowMax[x] > colMax[y]) {
				int i = incCol ? 1 : 0;
				arr[x][y] = rowMax[x] = colMax[y] = colMax[y] + i;
			} else {
				if (incRow) {
					arr[x][y] = rowMax[x] = colMax[y] = rowMax[x] + 1;
				} else if (incCol) {
					arr[x][y] = rowMax[x] = colMax[y] = colMax[y] + 1;
				} else {
					arr[x][y] = rowMax[x];
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 74, 54 }, { 1, 54, 83 } };
		CompressArray c = new CompressArray();
		c.compressArrayRowColWise(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
