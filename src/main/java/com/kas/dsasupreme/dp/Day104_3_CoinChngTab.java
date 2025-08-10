package com.kas.dsasupreme.dp;

public class Day104_3_CoinChngTab {
static int ans;
static int amount = 11;
static int n =3;
static int[] coins = new int[]{1,2,5};
static int[] dp = new int[amount+1];
	public static int coinMin(int amount){
		//base case
		dp[0] =0;
		
		
		
		for(int i=1;i<=amount;i++)
		{
			for(int j=0;j<n;j++){
				if(i-coins[j] >= 0 && dp[i-coins[j]] != Integer.MAX_VALUE)
				dp[i] = Math.min(dp[i], 1+dp[i-coins[j]]);
			}
		}
		if(dp[amount] == Integer.MAX_VALUE)
			return -1;

		
		return dp[amount];
	}
	public static void main(String[] args) {
		for(int i = 0;i<=amount;i++)
			dp[i] = Integer.MAX_VALUE;
		System.out.println(coinMin(amount));
	}
}
//0 1 1 2 3 5 8
	 // 1 2 3 4 5