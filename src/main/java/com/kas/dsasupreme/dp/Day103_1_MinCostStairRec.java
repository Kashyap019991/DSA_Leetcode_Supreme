package com.kas.dsasupreme.dp;

public class Day103_1_MinCostStairRec {
static int res;
static int count=0;
static int[] ipCost = new int[]{10,15,20};
	public static int minCostSt(int n){
		//base case
		if(n==0 || n==1) return ipCost[n]; 
		
		int res = minCostSt(n-1) + minCostSt(n-2) + ipCost[n];
		return res;
	}
	public static void main(String[] args) {
		int n = ipCost.length;	
		System.out.println(Math.min(minCostSt(n-1),minCostSt(n-2)));
	}
}
//0 1 1 2 3 5 8
	 // 1 2 3 4 5