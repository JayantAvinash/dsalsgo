package com.prac.dsalgo.general;

//https://leetcode.com/problems/valid-sudoku/
public class SudokuValidity {

	public boolean isValidSudoku(char[][] board) {
		int[][] rows = new int[9][9];
		int[][] cols = new int[9][9];
		int[][] boxes = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				int curr = board[i][j] - '0' - 1;
				rows[i][curr]++;
				if (rows[i][curr] > 1) {
					return false;
				}
				cols[j][curr]++;
				if (cols[j][curr] > 1) {
					return false;
				}
				int boxNo = i / 3 * 3 + j / 3;
				boxes[boxNo][curr]++;
				if (boxes[boxNo][curr] > 1) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char[][] sudoku = {
				  {'8','3','.','.','7','.','.','.','.'},
				  {'6','.','.','1','9','5','.','.','.'},
				  {'.','9','8','.','.','.','.','6','.'},
				  {'8','.','.','.','6','.','.','.','3'},
				  {'4','.','.','8','.','3','.','.','1'},
				  {'7','.','.','.','2','.','.','.','6'},
				  {'.','6','.','.','.','.','2','8','.'},
				  {'.','.','.','4','1','9','.','.','5'},
				  {'.','.','.','.','8','.','.','7','9'}
				};
		SudokuValidity s = new SudokuValidity();
		System.out.println(s.isValidSudoku(sudoku));

	}

}
