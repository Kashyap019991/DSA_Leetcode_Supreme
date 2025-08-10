package com.kas.dsasupreme.dp;

public class Day127__3_UniqueBstRecMemBU {
	static int uniqueBst(int n, int[] dp) {
		/*
		 * if (n <= 1) return 1;
		 */
		dp[0] = 1;
		dp[1] = 1;

		int ans = 0;
		// i as no. of nodes
		for (int i = 2; i <= n; i++) {
			// j as root nodes
			for (int j = 1; j <= i; j++) {
				dp[i] = dp[i] + (dp[j - 1] * dp[i - j]);
			}
		}
		return dp[n];

	}

	public static void main(String[] args) {

		int n = 3;
		int[] dp = new int[n + 1];
		// i as root node
		for (int i = 0; i <= n; i++) {
			dp[i] = 0;
		}
		System.out.println(uniqueBst(n, dp));
	}
}
