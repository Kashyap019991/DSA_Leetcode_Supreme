//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
package com.kas.dsasupreme._6_Recursion;

import java.util.Arrays;

class _1_RecursionL4_CoinChange2Mem {
    public static int coinChange(int[] coins , int amount,int[] dp) {
       
    	//base case
    	if(amount == 0)
    		return 0;
    	if(amount < 0)
    		return Integer.MAX_VALUE;// infinity or invalid
    	
    	if(dp[amount] != -1) return dp[amount];
    	
    	//1 case solve kr lo
    	int mini = Integer.MAX_VALUE;
    	for(int i = 0 ; i< coins.length; i++){
    		int ans =coinChange(coins, amount - coins[i],dp);
    		if(ans != Integer.MAX_VALUE)
    			mini = Math.min(mini, ans+1);
    	}
    	return dp[amount] = mini;
    		
    }
    
    public static void main(String[] args) {
    	
    	int[] coins = new int[]{1,2,3};
    	int target = 5;
    	int[] dp = new int[target+1];
    	Arrays.fill(dp, -1);
    	int ans = coinChange(coins,target,dp);
    	if(ans >= Integer.MAX_VALUE)
		 	ans =  -1;
		 //else ans;
		System.out.println(ans);
	}
}