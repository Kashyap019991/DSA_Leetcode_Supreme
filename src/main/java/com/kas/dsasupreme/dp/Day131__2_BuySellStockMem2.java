package com.kas.dsasupreme.dp;

import java.util.Arrays;

public class Day131__2_BuySellStockMem2 {
	 static int solveRecMem(int i , int buy, int[] prices,int[][] dp){
	        //base case if whole arr traversed
	        if(i == prices.length) return 0;
	        
	        if(dp[i][buy] != -1) return dp[i][buy];
	        int profit = 0;
	         if(buy == 1){
	             int buyKro = -prices[i] + solveRecMem(i+1,0,prices,dp);
	             int skipKro = 0 + solveRecMem(i+1,1,prices,dp);
	             profit = Math.max(buyKro,skipKro);
	         }
	        else
	        {
	            int sellKro = prices[i] + solveRecMem(i+1,1,prices,dp);   
	            int skipKro = 0 + solveRecMem(i+1,0,prices,dp);
	            profit = Math.max(sellKro,skipKro);
	        }
	        return dp[i][buy] = profit;
	    }
	public static void main(String[] args) {
		//multiple time b->s allowed
		int[] prices = new int[] { 7,1,5,3,6,4 }; //ans 7
		int[][] dp = new int[prices.length+1][2];
		for(int i=0;i<= prices.length;i++)
			Arrays.fill(dp[i], -1);
		System.out.println(solveRecMem(0,1,prices,dp));
	}
}
