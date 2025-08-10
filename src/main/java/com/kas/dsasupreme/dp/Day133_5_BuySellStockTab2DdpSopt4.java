package com.kas.dsasupreme.dp;

import java.util.Arrays;

//Here 2D DP will be used in 133_1 3D dp used T(C) : O(n*2) S(C): O(k)
public class Day133_5_BuySellStockTab2DdpSopt4 {
	static int solve2DDp(int k, int[] prices) {
		
		int n = prices.length;
		int[] curr = new int[(2*k)+1];
		int[] next = new int[(2*k)+1];
		Arrays.fill(curr, 0);
		Arrays.fill(next, 0);
		int profit = 0;
		//price array travrse
		for (int i = n-1; i >= 0; i--) {
			for (int OpNo = 0; OpNo < 2 * k; OpNo++) {

				if (OpNo % 2 == 0) {
					int buyKro = -prices[i] + next[OpNo + 1];
					int skipKro = 0 + next[OpNo];
					profit = Math.max(buyKro, skipKro);
				} else {
					int sellKro = prices[i] + next[OpNo + 1];
					int skipKro = 0 + next[OpNo];
					profit = Math.max(sellKro, skipKro);
				}
				curr[OpNo] = profit;
			}
			next = curr;
		}
		return next[0];
	}

	public static void main(String[] args) {
		// multiple time b->s allowed
		int[] prices = new int[] { 3, 3, 5, 0, 0, 3, 1, 4 }; // ans 6

		int k = 2;

		System.out.println(solve2DDp(k, prices));
	}
}
