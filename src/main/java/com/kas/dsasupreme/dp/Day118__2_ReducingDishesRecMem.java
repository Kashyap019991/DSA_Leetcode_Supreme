package com.kas.dsasupreme.dp;

import java.util.Arrays;

public class Day118__2_ReducingDishesRecMem {
	// pos //0, 1,2,3,4
	static int[] satisfaction = new int[] { -1,-8,0,5,-9 }; //ans 14
	
	//static int[] satisfaction = new int[] { 4,3,2 }; //ans 20
	static int n = satisfaction.length;
	static int[][] dp = new int[n+1][n+1];
	static int countDearr(int index, int time) {
		// here if frog reaches to 4 then stop
		if (index == satisfaction.length)
			return 0;
		
		if(dp[index][time] != -1 ) return dp[index][time];
		int inc = satisfaction[index] * (time+1) +(countDearr(index+1, time+1));
		int exc = 0 + countDearr(index+1, time);
		
		return dp[index][time] =Math.max(inc, exc);
	}

	public static void main(String[] args) {
		Arrays.sort(satisfaction);
		for(int i=0;i<=n;i++){
			for(int j=0;j<=n;j++)
			dp[i][j] = -1;
			
		}
		System.out.println(countDearr(0, 0));
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5