package com.kas.dsasupreme.dp;

import java.util.Arrays;

//Here 2D DP will be used in 133_1 3D dp used
public class Day133__4_BuySellStockTab2Ddp4 {
	static int solve2DDp(int k, int[] prices) {
		
		int n = prices.length;
		int[][] dp = new int[n + 1][(2 * k)+1];
		for (int i = 0; i <= n; i++)
			Arrays.fill(dp[i], 0);
		int profit = 0;
		//price array travrse
		for (int i = n-1; i >= 0; i--) {
			for (int OpNo = 0; OpNo < 2 * k; OpNo++) {

				if (OpNo % 2 == 0) {
					int buyKro = -prices[i] + dp[i + 1][OpNo + 1];
					int skipKro = 0 + dp[i + 1][OpNo];
					profit = Math.max(buyKro, skipKro);
				} else {
					int sellKro = prices[i] + dp[i + 1][OpNo + 1];
					int skipKro = 0 + dp[i + 1][OpNo];
					profit = Math.max(sellKro, skipKro);
				}
				dp[i][OpNo] = profit;
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		// multiple time b->s allowed
		int[] prices = new int[] { 3, 3, 5, 0, 0, 3, 1, 4 }; // ans 6

		int k = 2;

		System.out.println(solve2DDp(k, prices));
	}
}
