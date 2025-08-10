package com.kas.dsasupreme.dp;

public class Day107_1_RodCutRec {

static int t =7;
static int n = 3,x=5,y=2,z=2;
static int[] dp =new int[t+1];
	public static int rodCutMax(int i){
		//base case
		//if(i== 0) return ip[i];
		if(i<0) return Integer.MIN_VALUE;
		if(i == 0) return 0;
		if(dp[i] != -1) return dp[i];
		
		int a = rodCutMax(i-x) + 1;
		int b = rodCutMax(i-y) + 1;
		int c = rodCutMax(i-z) + 1;
		dp[i] = Math.max(a,Math.max(b, c));
		return dp[i];		
		
	}
/*public static int maxSumNonAdjNode(int i){
	//base case
	//if(i== 0) return ip[i];
	if(i>=n) return 0;
	
	int incl = maxSumNonAdjNode(i+2) + ip[i];
	int excl = maxSumNonAdjNode(i+1) + 0;
	
	return Math.max(incl,excl);		
	
}*/
	public static void main(String[] args) {
		for(int i=0;i<=t;i++)
			dp[i] = -1;
		System.out.println(rodCutMax(t));
	}
}
//0 1 1 2 3 5 8
	 // 1 2 3 4 5