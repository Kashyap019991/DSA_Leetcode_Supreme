package com.kas.dsasupreme.dp;

import java.util.Arrays;

public class Day132__3_BuySellStockTab3 {
	static int solveTab(int lmt,int[] prices, int[][][] dp) {
		// base case if whole arr traversed
		// if(i == prices.length) return 0;

		for (int i = prices.length - 1; i >= 0; i--) {
			for (int buy = 0; buy <= 1; buy++) {
				for (int limit = 1; limit <= lmt; limit++) {
					int profit = 0;
					if (buy == 1) {
						int buyKro = -prices[i] + dp[i + 1][0][limit];
						int skipKro = 0 + dp[i + 1][1][limit];
						profit = Math.max(buyKro, skipKro);
					} else {
						int sellKro = prices[i] + dp[i + 1][1][limit-1];
						int skipKro = 0 + dp[i + 1][0][limit];
						profit = Math.max(sellKro, skipKro);
					}
					dp[i][buy][limit] = profit;
				}
			}
		}
		return dp[0][1][2];
	}

	public static void main(String[] args) {
		// multiple time b->s allowed
		int lmt =2;
		int[] prices = new int[] { 3,3,5,0,0,3,1,4 }; // ans 6
		int[][][] dp = new int[prices.length+1][2][lmt+1];
		for(int i=0;i<= prices.length;i++)
			{
			for(int j=0;j<= 1;j++)
				Arrays.fill(dp[i][j], 0);
			}
		System.out.println(solveTab(lmt,prices,dp));
	}
}
