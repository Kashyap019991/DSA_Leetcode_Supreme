package com.kas.practice_javadsa;
class MinPrice {
    static int mini = Integer.MAX_VALUE;
    static int helper(int[] prices, int i,int[] selectCurr){
        if(i>=prices.length) return 0; 
        selectCurr[0] += (i==0?prices[0] : prices[i]);
        selectCurr[0] += helper(prices, (i==0?2:(2*i)+1),selectCurr);

		
		 
        return mini = Math.min(selectCurr[0],mini);
    }
    public static int minimumCoins(int[] prices) {
        helper(prices, 0,new int[]{0});
        return mini;
    }
    
    public static void main(String[] args) {
    	//1,3,6,12
    	//0,2,5,11
		int[] prices = {26,18,6,12,49,7,45,45};
		System.out.println(minimumCoins(prices));
	}
}