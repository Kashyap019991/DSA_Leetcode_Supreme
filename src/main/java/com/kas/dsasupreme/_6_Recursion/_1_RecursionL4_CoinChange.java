//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
package com.kas.dsasupreme._6_Recursion;
class _1_RecursionL4_CoinChange {
    public static int coinChange(int[] coins , int amount,int count) {
       
    	//base case
    	if(amount == 0)
    		return count;
    	if(amount < 0)
    		return Integer.MAX_VALUE;// infinity or invalid
    	
    	
    	//1 case solve kr lo
    	int mini = Integer.MAX_VALUE;
    	for(int i = 0 ; i< coins.length; i++){
    		int ans =coinChange(coins, amount - coins[i] , count+1);
    		mini = Math.min(mini, ans);
    	}
    	return mini;
    		
    }
    public static void main(String[] args) {
		
		System.out.println(coinChange(new int[]{1,2,3},5, 0));
	}
}