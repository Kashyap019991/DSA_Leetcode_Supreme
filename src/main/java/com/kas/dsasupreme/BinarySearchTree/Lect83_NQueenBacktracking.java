
package com.kas.dsasupreme.BinarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lect83_NQueenBacktracking {
	static ArrayList<String> res = new ArrayList<String>();

	public static Boolean isSafe(int row, int col, int[][] board, int n) {

		// check same row in left side, bcoz right side blank hoga
		int x = row, y = col;

		while (y >= 0) {
			if (board[x][y] == 1)
				return false;

			y--;
		}

		// check upward diagonal (1,2) --> (0,1) so , row-1, col-1
		x = row; y = col;
		while (x >= 0 && y >= 0) {
			if (board[x][y] == 1)
				return false;
			x--;
			y--;

		}

		// check downward diagonal (1,2) --> (2,1),(3,0) so , row+1, col-1
		x = row; y = col;
		while (x < n && y >= 0) {
			if (board[x][y] == 1)
				return false;
			x++;
			y--;

		}
		return true;
	}

	static List<List<Integer>> ans = new ArrayList<List<Integer>>();
	
	static int a=0;
	public static void solve(int[][] board, int col, int n, int k) {

		// base case if all col filled means col == 4
		if (col == n) {
			// add board to ans i.e 0 0 1 0 || 1 0 0 0 0 || 0 0 0 1 || 1 0 0 0
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				
				for (int j = 0; j < n; j++) {
					temp.add(board[i][j]);
				}
				
				
			}
			ans.add(temp);
			
			// then ret as no need to check next
			return;
		}

		for (int row = 0; row < n; row++) {

			if (isSafe(row, col, board, n)) {
				// place Q at same place
				board[row][col] = 1;

				// check for next col
				solve(board, col + 1, n,k);

				// backtrack
				board[row][col] = 0;
			}

		}
	}
	 
	public static void main(String args[]) {

		int n = 4;
		int[][] board = new int[n][n];

		for (int i = 0; i < n; i++) {
			Arrays.fill(board[i], 0);
		}
		int col = 0;
		solve(board, col, n, 0);
		System.out.println(ans);
		
		/*List<List<String>> parsedString = new ArrayList<List<String>>();
		
		for(List<Integer> l:ans){
			List<St>
			for(int k:l){
				
				if(k==0)
					
			}
		}*/
	}

}




