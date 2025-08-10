package com.kas.dsasupreme.dp;

public class Day132__1_BuySellStock3 {
	 static int solveRec(int i , int buy, int[] prices, int limit){
	        //base case if whole arr traversed
	        if(i == prices.length) return 0;
	        if(limit == 0) return 0;
	        
	        int profit = 0;
	         if(buy == 1){
	             int buyKro = -prices[i] + solveRec(i+1,0,prices,limit);
	             int skipKro = 0 + solveRec(i+1,1,prices,limit);
	             profit = Math.max(buyKro,skipKro);
	         }
	        else
	        {
	            int sellKro = prices[i] + solveRec(i+1,1,prices,limit-1);   
	            int skipKro = 0 + solveRec(i+1,0,prices,limit);
	            profit = Math.max(sellKro,skipKro);
	        }
	        return profit;
	    }
	public static void main(String[] args) {
		//multiple time b->s allowed
		int[] prices = new int[] { 3,3,5,0,0,3,1,4 }; //ans 6
		System.out.println(solveRec(0,1,prices,2));
	}
}
