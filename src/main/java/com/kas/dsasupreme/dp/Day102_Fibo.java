package com.kas.dsasupreme.dp;

public class Day102_Fibo {

	static int n = 6;
	static int[] dp = new int[n + 1];

	public static void main(String[] args) {
		// step 1 create dp array with val -1
		for (int i = 0; i <= n; i++) {
			dp[i] = -1;
		}
		System.out.println(fibo(n));
	}

	public static int fibo(int n) {

		// base case
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		// step 3 check mem value
		if (dp[n] != -1)
			return dp[n];

		// step 2 rec
		dp[n] = fibo(n - 1) + fibo(n - 2);
		return dp[n];
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5