package com.kas.dsasupreme.dp;

import java.util.Arrays;

public class Day133__1_BuySellStockTab3Ddp {
	//In Cont. of leet code 123, var 3
	static int solveTab3DDp(int[] prices, int lmt) {
		// base case if whole arr traversed
		// if(i == prices.length) return 0;

		int[][] curr = new int[2][lmt + 1];
		int[][] next = new int[2][lmt + 1];

		for (int i = 0; i <= 1; i++) {
			Arrays.fill(curr[i], 0);
			Arrays.fill(next[i], 0);
		}
		System.out.println();
		for (int i = prices.length - 1; i >= 0; i--) {
			for (int buy = 0; buy <= 1; buy++) {
				for (int limit = 1; limit <= lmt; limit++) {
					int profit = 0;
					if (buy == 1) {
						int buyKro = -prices[i] + next[0][limit];
						int skipKro = 0 + next[1][limit];
						profit = Math.max(buyKro, skipKro);
					} else {
						int sellKro = prices[i] + next[1][limit - 1];
						int skipKro = 0 + next[0][limit];
						profit = Math.max(sellKro, skipKro);
					}
					curr[buy][limit] = profit;
				}

				next = curr;
			}
		}
		return next[1][lmt];
	}

	public static void main(String[] args) {
		// multiple time b->s allowed
		int limit = 2;
		int k = 2; //atmost k transaction
		int[] prices = new int[] { 3,3,5,0,0,3,1,4  }; // ans 6
		int[][] dp = new int[prices.length + 1][k];
		for (int i = 0; i <= prices.length; i++)
			Arrays.fill(dp[i], 0);
		System.out.println(solveTab3DDp(prices, limit));
	}
}
