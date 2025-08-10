package com.kas.dsasupreme.dp;

public class Day121__3_Pizza3nSliceBUTab {
	// pos //0, 1,2,3,4
	//static int[] slices = new int[] {1,2,3,4,5,6}; // ans =10
	//static int[] slices = new int[] { 8, 9, 8, 6, 1, 1 }; // ans=16
	static int[] slices = new int[]{9,5,1,7,8,4,4,5,5,8,7,7};//ans =30
	
	
	static int countDearr() {
		int k = slices.length;
		int[][] dp1 = new int[k+2][k+2]; 
		int[][] dp2 = new int[k+2][k+2]; 
		for(int i=0;i<k+2;i++){
			for(int j = 0;j<k+2;j++)
			{dp1[i][j] = 0;
			dp2[i][j] = 0;}
		}


		for(int index = k-2;index>=0;index--)
		{
			for(int n=1;n<=k/3;n++){
				int inc = slices[index] + dp1[index + 2][n - 1];
				int exc = 0 + dp1[index + 1][n];
				dp1[index][n] = Math.max(inc, exc);
			}
		}
		int first = dp1[0][k / 3];

		for(int index = k-1;index>=1;index--)
		{
			for(int n=1;n<=k/3;n++){
				int inc = slices[index] + dp2[index + 2][n - 1];
				int exc = 0 + dp2[index + 1][n];
				dp2[index][n] = Math.max(inc, exc);
			}
		}
		int last = dp2[1][k / 3];
		return Math.max(first, last);

	}

	public static void main(String[] args) {
		// include 1st so skip last
		System.out.println(countDearr());
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5