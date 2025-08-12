package com.kas.practice_javadsa.aug_2025.Backtaracking;

import java.util.Arrays;

class P_6_NQueenConfigPrint{
	//int n=4;
	public boolean nQueenConfig(int n,int[][] board, int i){
	
		if(i == n){
			printBoard(board, n);
			return true;
		}
		
		for(int j=0;j<n;j++){

			//printBoard(board, n);
			if(canPlace(board,i, j,n)){
				board[i][j] =1;
				//printBoard(board, n);
				boolean success = nQueenConfig(n,board,i+1);
				if(success){
					//printBoard(board, n);
					return true;
				}
				//backtracking
				board[i][j] = 0;
			}

			
			
		}
		return false;
	}
	
	public boolean canPlace(int[][] board,int i, int j,int n){
	
		//column
		for(int x=0;x<i;x++){
			if(board[x][j] ==1)
				return false;
		}
		
		//diagonal left side -1.-1
		int x=i,y=j;
		while(x>=0 && y>=0){
			if(board[x][y] ==1)
				return false;
				
			x--;y--;
		}
		
		//diagonal right -1.+1
		x=i;y=j;
		while(x>=0 && y<n){
			if(board[x][y] ==1)
				return false;
				
			x--;y++;
		}
		
		return true;
		
	}
	
	public void printBoard(int[][] board,int n){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(board[i][j] +" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int n=4;
		int[][] board= new int[n][n];

		for(int i=0;i<n;i++)
			Arrays.fill(board[i],0);

		new P_6_NQueenConfigPrint().nQueenConfig(n,board,0);

	}
}