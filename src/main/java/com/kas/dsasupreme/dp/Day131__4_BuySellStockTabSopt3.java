package com.kas.dsasupreme.dp;

import java.util.Arrays;

public class Day131__4_BuySellStockTabSopt3 {
	static int solveTab(int[] prices) {
		// base case if whole arr traversed
		// if(i == prices.length) return 0;

		int[] curr = new int[2];
		int[] next = new int[2];
		
		Arrays.fill(curr,0);
		Arrays.fill(next,0);
		
		for (int i = prices.length - 1; i >= 0; i--) {
			for (int buy = 0; buy <= 1; buy++) {

				int profit = 0;
				if (buy == 1) {
					int buyKro = -prices[i] + next[0];
					int skipKro = 0 + next[1];
					profit = Math.max(buyKro, skipKro);
				} else {
					int sellKro = prices[i] + next[1];
					int skipKro = 0 + next[0];
					profit = Math.max(sellKro, skipKro);
				}
				curr[buy] = profit;
			}
			next = curr;
		}
		return next[1];
	}

	public static void main(String[] args) {
		// multiple time b->s allowed
		int[] prices = new int[] { 7, 1, 5, 3, 6, 4 }; // ans 7
		int[][] dp = new int[prices.length + 1][2];
		for (int i = 0; i <= prices.length; i++)
			Arrays.fill(dp[i], 0);
		System.out.println(solveTab(prices));
	}
}
