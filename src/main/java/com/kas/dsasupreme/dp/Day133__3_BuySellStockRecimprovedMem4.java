package com.kas.dsasupreme.dp;

import java.util.Arrays;

//Here 2D DP will be used in 133_1 3D dp used
public class Day133__3_BuySellStockRecimprovedMem4 {
	 static int solveRecMem2D(int i ,  int OpNo,int k, int[] prices,int[][] dp){
	        //base case if whole arr traversed
	        if(i == prices.length) return 0;
	        if(2 * k == OpNo) return 0;
	        if(dp[i][OpNo] != -1) return dp[i][OpNo]; 
	        
	        int profit = 0;
	         if(OpNo%2 == 0){
	             int buyKro = -prices[i] + solveRecMem2D(i+1,OpNo+1,k,prices,dp);
	             int skipKro = 0 + solveRecMem2D(i+1,OpNo,k,prices,dp);
	             profit = Math.max(buyKro,skipKro);
	         }
	        else
	        {
	            int sellKro = prices[i] + solveRecMem2D(i+1,OpNo+1,k,prices,dp);   
	            int skipKro = 0 + solveRecMem2D(i+1,OpNo,k,prices,dp);
	            profit = Math.max(sellKro,skipKro);
	        }
	        return dp[i][OpNo] = profit;
	    }
	public static void main(String[] args) {
		//multiple time b->s allowed
		int[] prices = new int[] { 3,3,5,0,0,3,1,4 }; //ans 6
		int n = prices.length;
		int k=2;
		int[][] dp = new int[n+1][2*k];
		for(int i = 0;i<=n;i++)
			Arrays.fill(dp[i], -1);
		
		System.out.println(solveRecMem2D(0,0,k,prices,dp));
	}
}
