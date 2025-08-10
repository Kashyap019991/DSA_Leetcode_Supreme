package com.kas.dsasupreme.dp;

public class Day107_3_RodCutRecTab {

	static int t = 7;
	static int n = 3, x = 5, y = 2, z = 2;
	static int[] dp = new int[t + 1];

	public static int rodCutMax(int i) {
		// base case
		// if(i== 0) return ip[i];
		// if(i<0) return Integer.MIN_VALUE;
		dp[0] = 0;

		for (int j = 1; j <= t; j++) {
			if (j - x >= 0)
				dp[j] = Math.max(dp[j], dp[j - x] + 1);

			if (j - y >= 0)
				dp[j] = Math.max(dp[j], dp[j - y] + 1);
			
			if (j - z >= 0 )
				dp[j] = Math.max(dp[j], dp[j - z] + 1);
		}

		if(dp[i] <0)
			return 0;
		else
			return dp[i];

	}
	public static void main(String[] args) {
		for (int i = 0; i <= t; i++)
			//<0 ke liye 2nd base case handle if(i<0)
			dp[i] = Integer.MIN_VALUE;
		System.out.println(rodCutMax(t));
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5