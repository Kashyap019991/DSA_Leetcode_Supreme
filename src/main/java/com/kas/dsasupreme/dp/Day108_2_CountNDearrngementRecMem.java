package com.kas.dsasupreme.dp;

public class Day108_2_CountNDearrngementRecMem {
//for circular house , first is nebr of last 
//or same as MaxSumNn adj
static int n =4;//{0,1,2} ==> {1,0,2},{2,1,0},------
static int[] dp = new int[n+1];
static final int MOD = 1000000007; 
	static int countDearr(int n){
		
		if(n==1) return 0;
		if(n==2) return 1;
		
		if(dp[n] != -1) return dp[n];
		dp[n] = ((n-1)%MOD) * ((countDearr(n-1)%MOD) + (countDearr(n-2)%MOD));
		
		
		return dp[n];
	}
	public static void main(String[] args) {
		for(int i=0;i<=n;i++)
			dp[i] = -1;
		System.out.println(countDearr(n));
	}
}
//0 1 1 2 3 5 8
	 // 1 2 3 4 5