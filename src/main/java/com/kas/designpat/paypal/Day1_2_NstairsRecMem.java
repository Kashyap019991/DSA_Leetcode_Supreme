package com.kas.designpat.paypal;

public class Day1_2_NstairsRecMem {
static int res;
static int n = 3;
static int[] dp = new int[n+1];
static int count=0;
	public static int nStairs(int n){
		
		if(n < 0) return 0;
		if(n == 0) return 1;
		if(dp[n] != -1) return dp[n];
		int res = nStairs(n-1) + nStairs(n-2);
		dp[n] = res;
		return dp[n];
		
	}
	public static void main(String[] args) {
		int count = 0;	
		for(int i = 0 ; i<= n;i++)
			dp[i] = -1;
		System.out.println(nStairs(n));
	}
}
//0 1 1 2 3 5 8
	 // 1 2 3 4 5