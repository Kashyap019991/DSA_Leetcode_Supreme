package com.kas.dsasupreme.dp;

public class Day115__1_MaximalSquareRec {

	
	//static int[][] ip = new int[][]{{1,1},{1,1}};
	static int[][] ip = new int[][]{{0,1},{1,0}};
	/*static int[][] ip = new int[][]{{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};*/
	static int maxim = 0;
	
	static int countDearr(int i,int j) {

		if (j >= ip[0].length || i >= ip.length) return 0;
		
		int right = countDearr(i, j+1);
		int diagnal = countDearr(i+1, j+1);
		int down = countDearr(i+1, j);
		
		if(ip[i][j] == 1){
			int ans = 1+ Math.min(right, Math.min(diagnal,down));
			maxim = Math.max(maxim, ans);
			return ans;
		}
		else
			return 0;
		
	}

	public static void main(String[] args) {
		countDearr(0,0);
		System.out.println(maxim);
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5