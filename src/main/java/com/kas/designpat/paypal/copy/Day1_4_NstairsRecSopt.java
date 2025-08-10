package com.kas.designpat.paypal.copy;

public class Day1_4_NstairsRecSopt {
	static int res;
	static int n = 4;
	static int[] dp = new int[n + 1];
	static int count = 0;

	public static int nStairs(int n) {

		// if(n < 0) return 0;
		// if(n == 0) return 1;
		int prev2 = 1;
		// 1way to reach 1st stair
		int prev1 = 1;
		for (int i = 2; i <= n; i++) {
			int curr = prev1 + prev2;
			prev2 = prev1;
			prev1 = curr;
		}
		return prev1;

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