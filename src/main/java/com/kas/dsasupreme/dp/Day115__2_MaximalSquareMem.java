package com.kas.dsasupreme.dp;

public class Day115__2_MaximalSquareMem {

	
	static int[][] ip = new int[][]{{1,1},{1,1}};
	//static int[][] ip = new int[][]{{0,1},{1,0}};
	//static int[][] ip = new int[][]{{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
	static int maxim = 0;
	static int m = ip.length;//row
	static int n = ip[0].length; //cols
	static int[][] dp = new int[m][n];
	
	static int countDearr(int i,int j) {

		if (j >= ip[0].length || i >= ip.length) return 0;
		
		int right = countDearr(i, j+1);
		int diagnal = countDearr(i+1, j+1);
		int down = countDearr(i+1, j);
		
		if(dp[i][j] != -1) return dp[i][j];
		if(ip[i][j] == 1){
			dp[i][j] = 1+ Math.min(right, Math.min(diagnal,down));
			maxim = Math.max(maxim, dp[i][j]);
			return dp[i][j];
		}
		else
			return 0;
		
	}

	public static void main(String[] args) {
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++){
				dp[i][j] = -1;
			}
		}
		
		countDearr(0,0);
		System.out.println(maxim);
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5