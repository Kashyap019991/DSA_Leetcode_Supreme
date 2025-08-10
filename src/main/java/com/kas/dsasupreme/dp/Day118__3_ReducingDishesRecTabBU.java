package com.kas.dsasupreme.dp;

import java.util.Arrays;

public class Day118__3_ReducingDishesRecTabBU {
	// pos //0, 1,2,3,4
	//static int[] satisfaction = new int[] { -1, -8, 0, 5, -9 }; // ans 14

	static int[] satisfaction = new int[] { 4,3,2 }; //ans 20
	static int n = satisfaction.length;
	static int[][] dp = new int[n + 1][n + 1];

	static int countDearr() {
		// here if frog reaches to 4 then stop
		/*
		 * if (index == satisfaction.length) return 0;
		 */

		for (int index = n - 1; index >= 0; index--) {
			for (int time = index; time >= 0; time--) {
				int inc = satisfaction[index] * (time + 1) + (dp[index + 1][time + 1]);
				int exc = 0 + dp[index + 1][time];
				dp[index][time] = Math.max(inc, exc);
			}

		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		Arrays.sort(satisfaction);
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++)
				dp[i][j] = 0;

		}
		System.out.println(countDearr());
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5