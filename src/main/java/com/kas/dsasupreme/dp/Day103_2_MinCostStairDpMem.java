package com.kas.dsasupreme.dp;

public class Day103_2_MinCostStairDpMem {
static int res;
static int count=0;
static int[] ipCost = new int[]{10,15,20};
static int n = ipCost.length;
//step-1
static int[] dp = new int[n+1];
	public static int minCostSt(int n){
		//base case
		if(n==0)
		dp[0] = ipCost[0];
		if(n==1)
		dp[1] = ipCost[1];
		
		//step-3 fetch from dp
		if(dp[n] != -1) return dp[n];
		
		//step-2
		dp[n] = Math.min(minCostSt(n-1) ,minCostSt(n-2)) + ipCost[n];
		return dp[n];
	}
	public static void main(String[] args) {
			
		for(int i=0; i<=n;i++)
			dp[i] = -1;
		System.out.println(Math.min(minCostSt(n-1),minCostSt(n-2)));
	}
}
//0 1 1 2 3 5 8
	 // 1 2 3 4 5