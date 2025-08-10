package com.kas.dsasupreme.dp;

public class Day131__1_BuySellStock2 {
	 static int solveRec(int i , int buy, int[] prices){
	        //base case if whole arr traversed
	        if(i == prices.length) return 0;
	        
	        int profit = 0;
	         if(buy == 1){
	             int buyKro = -prices[i] + solveRec(i+1,0,prices);
	             int skipKro = 0 + solveRec(i+1,1,prices);
	             profit = Math.max(buyKro,skipKro);
	         }
	        else
	        {
	            int sellKro = prices[i] + solveRec(i+1,1,prices);   
	            int skipKro = 0 + solveRec(i+1,0,prices);
	            profit = Math.max(sellKro,skipKro);
	        }
	        return profit;
	    }
	public static void main(String[] args) {
		//multiple time b->s allowed
		int[] prices = new int[] { 7,1,5,3,6,4 }; //ans 7
		System.out.println(solveRec(0,1,prices));
	}
}
