package com.prac.dsalgo.bfs;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/01-matrix/
public class DistanceMatrix {

	public int[][] updateMatrix(int[][] matrix) {
		int[][] distance = new int[matrix.length][matrix[0].length];
		Queue<Position> q = new LinkedList<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					q.add(new Position(i, j, 0));
				}
			}
		}
		while (!q.isEmpty()) {
			Position a = q.remove();
			if (a.x > 0 && matrix[a.x - 1][a.y] != 0 && distance[a.x - 1][a.y] == 0) {
				distance[a.x - 1][a.y] = 1 + a.val;
				q.add(new Position(a.x - 1, a.y, 1 + a.val));
			}
			if (a.x < matrix.length - 1 && matrix[a.x + 1][a.y] != 0 && distance[a.x + 1][a.y] == 0) {
				distance[a.x + 1][a.y] = 1 + a.val;
				q.add(new Position(a.x + 1, a.y, 1 + a.val));
			}
			if (a.y > 0 && matrix[a.x][a.y - 1] != 0 && distance[a.x][a.y - 1] == 0) {
				distance[a.x][a.y - 1] = 1 + a.val;
				q.add(new Position(a.x, a.y - 1, 1 + a.val));
			}
			if (a.y < matrix[0].length - 1 && matrix[a.x][a.y + 1] != 0 && distance[a.x][a.y + 1] == 0) {
				distance[a.x][a.y + 1] = 1 + a.val;
				q.add(new Position(a.x, a.y + 1, 1 + a.val));
			}
		}
		return distance;
	}

	class Position {
		int x;
		int y;
		int val;

		Position(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
		DistanceMatrix dm = new DistanceMatrix();
		int[][] distanceMatrix = dm.updateMatrix(matrix);
		for (int i = 0; i < distanceMatrix.length; i++) {
			for (int j = 0; j < distanceMatrix[0].length; j++) {
				System.out.print(distanceMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
