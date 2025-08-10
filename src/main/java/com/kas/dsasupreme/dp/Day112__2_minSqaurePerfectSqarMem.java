package com.kas.dsasupreme.dp;

public class Day112__2_minSqaurePerfectSqarMem {

	static int n = 5;
	static int[] dp = new int[n+1];

	static int countDearr(int n) {

		if (n == 0)
			return 0;
		if(n<0) return Integer.MAX_VALUE;
		if(dp[n]!=-1) return dp[n];
		int ans = n;
		for (int i = 1; i*i <= n; i++)
			ans = Math.min(ans, 1+countDearr(n - i*i));
		dp[n] = ans;
		return dp[n];
		
	}

	public static void main(String[] args) {
		for(int i=0;i<=n;i++)
			dp[i] = -1;
		System.out.println(countDearr(n));
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5