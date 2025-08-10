package com.kas.dsasupreme.dp;

public class Day103_3_MinCostStairDpBottomUp {
static int res;
static int count=0;
static int[] ipCost = new int[]{10,15,20};
static int n = ipCost.length;
//step-1
static int[] dp = new int[n+1];
	public static int minCostSt(int n){
		//base case to dp st-2
		dp[0] = ipCost[0];
		dp[1] = ipCost[1];
		
		//step-3 fetch from dp
		for(int i=2;i<n;i++)
		dp[i] = Math.min(dp[i-1] , dp[i-2]) + ipCost[i];
		return Math.min(dp[n-1], dp[n-2]);
	}
	public static void main(String[] args) {
			
		/*for(int i=0; i<=n;i++)
			dp[i] = -1;*/
		System.out.println(minCostSt(n));
	}
}
//0 1 1 2 3 5 8
	 // 1 2 3 4 5