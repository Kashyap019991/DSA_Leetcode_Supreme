package com.kas.dsasupreme.dp;

public class Day112__3_minSqaurePerfectSqarMemTab {

	static int n = 5;
	static int[] dp = new int[n+1];

	static int countDearr(int n) {

/*		if (n == 0)
			return 0;*/
		dp[0] = 0;
		//if(dp[n]!=-1) return dp[n];
		int ans = n;
		
		//1st loop for each target 1 to 5 
		for(int i=1;i<=n;i++){
		for (int j = 1; j*j <= n; j++)//for each number 
			dp[i] = Math.min(dp[i], 1+countDearr(n - j*j));
		}
	
		return dp[n];
		
	}

	public static void main(String[] args) {
		for(int i=0;i<=n;i++)
			dp[i] = Integer.MAX_VALUE;
		System.out.println(countDearr(n));
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5