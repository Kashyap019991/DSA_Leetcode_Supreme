package com.kas.dsasupreme.dp;

public class Day116__3_MinScoreTriangleTabBU {

	// static int[] ip = new int[]{1,2,3}; //ans = 6
	static int[] ip = new int[] { 5, 3, 7, 4 }; // ans =144
	static int n = ip.length;
	static int[][] dp = new int[n][n];

	static int countDearr() {

		// if(i+1 == j) return 0;
		// if(dp[i][j] != -1) return dp[i][j];
		
		for (int i = n - 1; i >= 0; i--) {//solve(0,n-1)

			for (int j = i + 2; j < n; j++) {
				int ans = Integer.MAX_VALUE;
				for (int k = i + 1; k < j; k++) {
					ans = Math.min(ans, 
							((ip[i] * ip[j] * ip[k]) + dp[i][k] + dp[k][j]));

				}
				dp[i][j] = ans;
			}
		}
		
		return dp[0][n-1];
	}

	public static void main(String[] args) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = 0;
			}
		}
		System.out.println(countDearr());
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5