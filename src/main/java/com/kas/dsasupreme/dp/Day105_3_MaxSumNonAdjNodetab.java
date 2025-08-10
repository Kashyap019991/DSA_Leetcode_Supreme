package com.kas.dsasupreme.dp;

public class Day105_3_MaxSumNonAdjNodetab {

	static int n = 4;
	static int[] ip = new int[] { 9, 9, 8, 2 };
	static int[] dp = new int[n + 1];

	public static int maxSumNonAdjNode(int n) {

		dp[0] = ip[0];
		dp[1] = Math.max(ip[0], ip[1]); // base case

		for (int i = 2; i <= n; i++) {
			int incl = dp[i - 2] + ip[i];
			int excl = dp[i - 1] + 0;

			dp[i] = Math.max(incl, excl);

		}
		return dp[n-1];
	}

	public static void main(String[] args) {
		for (int i = 0; i <= n; i++)
			dp[i] = 0;
		System.out.println(maxSumNonAdjNode(n-1));
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5