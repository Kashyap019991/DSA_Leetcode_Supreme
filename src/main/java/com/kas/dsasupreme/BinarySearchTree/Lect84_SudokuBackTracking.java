
package com.kas.dsasupreme.BinarySearchTree;

import java.util.Arrays;

//LC 37
public class Lect84_SudokuBackTracking {

	static Boolean isSafe(int row, int col, char[][] board, char val) {

		//
		for (int i = 0; i < 9; i++) {
			// check in row
			if (board[row][i] == val)
				return false;
			// check col
			if (board[i][col] == val)
				return false;

			// check 3*3 matrix
			if (board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] == val)
				return false;

		}
		return true;
	}

	static boolean solveSudoku(char[][] board) {

		// check every cell row by row
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {

				if (board[row][col] == '.') {
					// put 1 to 9 in cell
					for (char c = '1'; c <= '9'; c++) {
						if (isSafe(row, col, board, c)) {
							board[row][col] = c;

							if (solveSudoku(board))
								return true;
							else
								board[row][col] = '.';
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String args[])

	{
		
		char[][] board = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
			{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
			{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
			{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
			{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

	System.out.println(solveSudoku(board));
	//Array.f
	System.out.println(Arrays.deepToString(board));
	}

}
