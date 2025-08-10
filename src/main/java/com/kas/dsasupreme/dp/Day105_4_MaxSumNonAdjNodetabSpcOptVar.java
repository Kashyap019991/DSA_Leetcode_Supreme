package com.kas.dsasupreme.dp;

public class Day105_4_MaxSumNonAdjNodetabSpcOptVar {

static int n =4;
static int[] ip = new int[]{1,2,3,1};
		//{ 1, 2, 9, 4, 5, 0, 4, 11, 6 };
		//{9,9,8,2};
static int[] dp = new int[n+1];
	public static int maxSumNonAdjNode(int n){
		
		int prev2 = ip[0];
		int prev1 = Math.max(ip[0],ip[1]);
		//base case
		
		for(int i=2;i<=n;i++){
			int incl = prev2 + ip[i];
			int excl = prev1 + 0;
			int curr = Math.max(incl,excl);
			prev2 = prev1;
			prev1 =curr;
		
		}
		
		
		
		return prev1;
		
	}
	public static void main(String[] args) {
		
		System.out.println(maxSumNonAdjNode(n-1));
	}
}
//0 1 1 2 3 5 8
	 // 1 2 3 4 5