package com.kas.dsasupreme.dp;

//Here 2D DP will be used in 133_1 3D dp used
public class Day133__2_BuySellStockRecimproved4 {
	 static int solveRec(int i ,  int OpNo,int k, int[] prices){
	        //base case if whole arr traversed
	        if(i == prices.length) return 0;
	        if(2 * k == OpNo) return 0;
	        
	        int profit = 0;
	         if(OpNo%2 == 0){
	             int buyKro = -prices[i] + solveRec(i+1,OpNo+1,k,prices);
	             int skipKro = 0 + solveRec(i+1,OpNo,k,prices);
	             profit = Math.max(buyKro,skipKro);
	         }
	        else
	        {
	            int sellKro = prices[i] + solveRec(i+1,OpNo+1,k,prices);   
	            int skipKro = 0 + solveRec(i+1,OpNo,k,prices);
	            profit = Math.max(sellKro,skipKro);
	        }
	        return profit;
	    }
	public static void main(String[] args) {
		//multiple time b->s allowed
		int k = 4;
		//int[] prices = new int[] { 3,3,5,0,0,3,1,4 }; //ans 6 , k=2
		
		int[] prices = new int[]  {1,2,4,2,5,7,2,4,9,0};// ans 15 , k=4
		System.out.println(solveRec(0,0,k,prices));
	}
}
