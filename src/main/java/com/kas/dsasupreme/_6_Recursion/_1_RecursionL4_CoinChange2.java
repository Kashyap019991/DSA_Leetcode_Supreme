//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
package com.kas.dsasupreme._6_Recursion;
class _1_RecursionL4_CoinChange2 {
    public static int coinChange(int[] coins , int amount) {
       
    	//base case
    	if(amount == 0)
    		return 0;
    	if(amount < 0)
    		return Integer.MAX_VALUE;// infinity or invalid
    	
    	
    	//1 case solve kr lo
    	int mini = Integer.MAX_VALUE;
    	for(int i = 0 ; i< coins.length; i++){
    		int ans =coinChange(coins, amount - coins[i]);
    		if(ans != Integer.MAX_VALUE)
    			mini = Math.min(mini, ans+1);
    	}
    	return mini;
    		
    }
    public static void main(String[] args) {
		
		System.out.println(coinChange(new int[]{1,2,3},5));
	}
}