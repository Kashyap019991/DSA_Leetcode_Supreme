package com.kas.dsasupreme.dp;

public class Day102_FiboBottomUp {

	static int n = 6;
	//step 1
	static int[] dp = new int[n + 1];

	public static void main(String[] args) {
		// step 2
		dp[0] = 0;
		dp[1] = 1;
		
		//step3
		for(int i=2;i<=n;i++)
			dp[i] = dp[i-1] + dp[i-2];
		
		System.out.println(dp[n]);
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5