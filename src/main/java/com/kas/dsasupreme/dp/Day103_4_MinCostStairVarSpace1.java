package com.kas.dsasupreme.dp;

public class Day103_4_MinCostStairVarSpace1 {
static int res;
static int count=0;
static int[] ipCost = new int[]{1,100,1,1,1,100,1,1,100,1};
static int n = ipCost.length;
//step-1
	public static int minCostSt(int n){
		//base case to dp st-2
		int prev2 = ipCost[0];
		int prev1 = ipCost[1];
		
		//step-3 fetch from dp
		for(int i=2;i<n;i++)
		{
			int curr = Math.min(prev1, prev2) + ipCost[i];
			prev2 = prev1;
			prev1 = curr;
			
		}
		return Math.min(prev1, prev2);
	}
	public static void main(String[] args) {
		System.out.println(minCostSt(n));
	}
}
//0 1 1 2 3 5 8
	 // 1 2 3 4 5