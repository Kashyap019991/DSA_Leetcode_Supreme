package com.kas.dsasupreme.dp;

public class Day127__2_UniqueBstRecMem {
	static int uniqueBst(int n, int[] dp) {
		if (n <= 1)
			return 1;
		
		if(dp[n] != -1) return dp[n];
		int ans = 0;
		//no of nodes
		for (int i = 1; i <= n; i++) {
			
			ans = ans + (uniqueBst(i-1,dp) * uniqueBst(n-i,dp));
		}
		return dp[n] = ans;

	}

	public static void main(String[] args) {

		int n = 3;
		int[] dp = new int[n+1];
		//i as root node
		for(int i = 0;i<=n;i++){
			dp[i] = -1;
		}
		System.out.println(uniqueBst(n,dp));
	}
}
