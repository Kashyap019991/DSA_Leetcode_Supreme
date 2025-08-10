package com.kas.dsasupreme.dp;

public class Day105_2_MaxSumNonAdjNodeMem {

	static int n = 4;
	static int[] ip = new int[] { 9, 9, 8, 2 };
	static int[] dp = new int[n + 1];

	public static int maxSumNonAdjNode(int i) {
		// base case
		/*if (i == 0)
			return ip[i];*/
		if (i < 0)
			return 0;
		if (dp[i] != -1)
			return dp[i];
		int incl = maxSumNonAdjNode(i - 2) + ip[i];
		int excl = maxSumNonAdjNode(i - 1) + 0;

		dp[i] = Math.max(incl, excl);
		return dp[i];

	}

	/*
	 * public static int maxSumNonAdjNode(int i) { // base case
	 * 
	 * if (i == 0) return ip[i];
	 * 
	 * if (i >= n) return 0; if (dp[i] != -1) return dp[i]; int incl =
	 * maxSumNonAdjNode(i + 2) + ip[i]; int excl = maxSumNonAdjNode(i + 1) + 0;
	 * 
	 * dp[i] = Math.max(incl, excl); return dp[i];
	 * 
	 * }
	 */

	public static void main(String[] args) {
		for (int i = 0; i <= n; i++)
			dp[i] = -1;
		System.out.println(maxSumNonAdjNode(n - 1));
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5