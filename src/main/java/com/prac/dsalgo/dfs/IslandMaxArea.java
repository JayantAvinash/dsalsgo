package com.prac.dsalgo.dfs;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/max-area-of-island/
public class IslandMaxArea {

	public int maxAreaOfIsland(int[][] grid) {
		Queue<Coordinate> q = new LinkedList<>();
		int max = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 0) {
					continue;
				}
				int currentMax = 0;
				q.offer(new Coordinate(i, j));
				grid[i][j] = 0;
				while (!q.isEmpty()) {
					Coordinate current = q.poll();
					int x = current.x;
					int y = current.y;
					currentMax++;
					if (y > 0 && grid[x][y - 1] > 0) {
						q.offer(new Coordinate(x, y - 1));
						grid[x][y - 1] = 0;
					}
					if (y < grid[i].length - 1 && grid[x][y + 1] > 0) {
						q.offer(new Coordinate(x, y + 1));
						grid[x][y + 1] = 0;
					}
					if (x > 0 && grid[x - 1][y] > 0) {
						q.offer(new Coordinate(x - 1, y));
						grid[x - 1][y] = 0;
					}
					if (x < grid.length - 1 && grid[x + 1][y] > 0) {
						q.offer(new Coordinate(x + 1, y));
						grid[x + 1][y] = 0;
					}
				}
				max = Math.max(max, currentMax);
			}
		}
		return max;
	}

	class Coordinate {
		int x;
		int y;

		Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public int maxAreaOfIslandRecursive(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					int area = dfs(grid, i, j, m, n, 0);
					max = Math.max(area, max);
				}
			}
		}
		return max;
	}

	int dfs(int[][] grid, int i, int j, int m, int n, int area) {
		if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
			return area;
		}
		grid[i][j] = 0;
		area++;
		area = dfs(grid, i + 1, j, m, n, area);
		area = dfs(grid, i, j + 1, m, n, area);
		area = dfs(grid, i - 1, j, m, n, area);
		area = dfs(grid, i, j - 1, m, n, area);
		return area;
	}

	public static void main(String[] args) {
		int [][]grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
				 {0,0,0,0,0,0,0,1,1,1,0,0,0},
				 {0,1,1,0,1,0,0,0,0,0,0,0,0},
				 {0,1,0,0,1,1,0,0,1,0,1,0,0},
				 {0,1,0,0,1,1,0,0,1,1,1,0,0},
				 {0,0,0,0,0,0,0,0,0,0,1,0,0},
				 {0,0,0,0,0,0,0,1,1,1,0,0,0},
				 {0,0,0,0,0,0,0,1,1,0,0,0,0}};
		IslandMaxArea i = new IslandMaxArea();
		System.out.println(i.maxAreaOfIsland(grid));

	}

}
