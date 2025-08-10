package com.kas.dsasupreme.dp;

import java.util.Arrays;

public class Day132__2_BuySellStockMem3 {
	 static int solveRecMem(int i , int buy,int limit, int[] prices,int[][][] dp){
	        //base case if whole arr traversed
	        if(i == prices.length) return 0;
	        if(limit == 0) return 0;
	        
	        if(dp[i][buy][limit] != -1) return dp[i][buy][limit];
	        int profit = 0;
	         if(buy == 1){
	             int buyKro = -prices[i] + solveRecMem(i+1,0,limit,prices,dp);
	             int skipKro = 0 + solveRecMem(i+1,1,limit,prices,dp);
	             profit = Math.max(buyKro,skipKro);
	         }
	        else
	        {
	            int sellKro = prices[i] + solveRecMem(i+1,1,limit-1,prices,dp);   
	            int skipKro = 0 + solveRecMem(i+1,0,limit,prices,dp);
	            profit = Math.max(sellKro,skipKro);
	        }
	        return dp[i][buy][limit] = profit;
	    }
	public static void main(String[] args) {
		//multiple time b->s allowed
		int[] prices = new int[] {  3,3,5,0,0,3,1,4 }; //ans 7
		int limit= 2;
		int[][][] dp = new int[prices.length+1][2][limit+1];
		for(int i=0;i<= prices.length;i++)
			{
			for(int j=0;j<= 1;j++)
				Arrays.fill(dp[i][j], -1);
			}
		System.out.println(solveRecMem(0,1,2,prices,dp));
	}
}
