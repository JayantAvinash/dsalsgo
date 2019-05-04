package com.prac.dsalgo.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:

0 represents the obstacle can't be reached.
1 represents the ground can be walked through.
The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.
 

You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value 1).

You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.

You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.
Input: 
[
 [1,2,3],
 [0,0,4],
 [7,6,5]
]
Output: 6
*/
public class CutoffTreeGolfEvent {

	int[] dx = { -1, 1, 0, 0 };
	int[] dy = { 0, 0, -1, 1 };

	public int cutoffTree(List<List<Integer>> forest) {
		List<int[]> trees = new ArrayList<>();
		for (int i = 0; i < forest.size(); i++) {
			for (int j = 0; j < forest.get(i).size(); j++) {
				if(forest.get(i).get(j) > 0) {
					trees.add(new int[] { forest.get(i).get(j), i, j });
				}
			}
		}
		Collections.sort(trees, (a, b) -> Integer.compare(a[0], b[0]));
		int ans = 0, sx = 0, sy = 0;
		for (int[] tree : trees) {
			int d = distByBFS(forest, sx, sy, tree[1], tree[2]);
			if (d < 0) {
				return -1;
			}
			ans += d;
			sx = tree[1];
			sy = tree[2];
		}
		return ans;
	}

	private int distByBFS(List<List<Integer>> forest, int sx, int sy, int tx, int ty) {
		int X = forest.size(), Y = forest.get(0).size();
		boolean[][] visited = new boolean[X][Y];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { sx, sy, 0 });
		visited[sx][sy] = true;
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			if (current[0] == tx && current[1] == ty) {
				return current[2];
			}
			for (int i = 0; i < 4; i++) {
				int x = current[0] + dx[i];
				int y = current[1] + dy[i];
				if (x >= 0 && x < X && y < Y && y >= 0 && !visited[x][y] && forest.get(x).get(y) > 0) {
					queue.add(new int[] { x, y, current[2] + 1 });
					visited[x][y] = true;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int [][]forestArr = {{1,2,3},
                {0,0,4},
                {7,6,5}};
		*/
		int [][]forestArr = 	{
		 {1,2,3},
		 {0,0,0},
		 {7,6,5}
		};
		List<List<Integer>> forest = new ArrayList<>();
		for(int i = 0; i < forestArr.length; i++) {
			List<Integer> forestSubList = new ArrayList<>();
			for(int j = 0; j < forestArr[i].length; j++) {
				forestSubList.add(forestArr[i][j]);
			}
			forest.add(forestSubList);
		}
		CutoffTreeGolfEvent cutoff = new CutoffTreeGolfEvent();
		System.out.println(cutoff.cutoffTree(forest));
	}

}
