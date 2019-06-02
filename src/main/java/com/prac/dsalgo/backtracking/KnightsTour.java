package com.prac.dsalgo.backtracking;

public class KnightsTour {
	
	public int[][] createKnightsTour() {
		int tourPath[][] = new int[8][8];
		
		tourPath[0][0] = 1;
		createPath(tourPath, 0, 0, 1);
		return tourPath;
	}

	private boolean createPath(int[][] tourPath, int x, int y, int noOfMoves) {
		if(noOfMoves == 64) {
			return true;
		}
		//System.out.println(noOfMoves);
		int []xMoves = {2, 1, -1,-2, -2, -1, 1, 2};
		int []yMoves = {1, 2, 2, 1, -1, -2, -2, -1};
		for(int i = 0; i < 8; i++) {
			int nextX = x + xMoves[i];
			int nextY = y + yMoves[i];
			if(isSafe(nextX, nextY, tourPath)) {
				tourPath[nextX][nextY] = noOfMoves + 1;
				boolean traversed = createPath(tourPath, nextX, nextY, noOfMoves + 1);
				if(traversed) {
					return true;
				} else {
					tourPath[nextX][nextY] = 0;
				}
			}
		}
		return false;
	}

	private boolean isSafe(int i, int j, int[][] tourPath) {
		return (i >= 0 && i < 8 && j >= 0 && j < 8 && tourPath[i][j] == 0);
	}

	public static void main(String[] args) {
		KnightsTour kt = new KnightsTour();
		int[][] path = kt.createKnightsTour();
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				System.out.print(path[i][j] + " ");
			}
			System.out.println();
		}

	}

}
