package com.kas.designpat.copy;

public class Day1_3_NstairsRecTabBU {
	static int res;
	static int n = 4;
	static int[] dp = new int[n + 1];
	static int count = 0;

	public static int nStairs(int n) {

		// if(n < 0) return 0;
		// if(n == 0) return 1;
		dp[0] = 1;
		// 1way to reach 1st stair
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];

	}

	public static void main(String[] args) {
		int count = 0;
		for (int i = 0; i <= n; i++)
			dp[i] = 0;
		System.out.println(nStairs(n));
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5