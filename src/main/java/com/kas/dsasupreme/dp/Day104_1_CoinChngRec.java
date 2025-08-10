package com.kas.dsasupreme.dp;

public class Day104_1_CoinChngRec {
static int ans;
static int amount = 7;
static int n =3;
static int[] coins = new int[]{1,2,3};
	public static int coinMin(int amount){
		//base case
		if(amount == 0) return 0;
		if(amount < 0) return Integer.MAX_VALUE;
		int mini = Integer.MAX_VALUE;
		
		for(int i=0;i<n;i++)
		{
			int ans = coinMin(amount - coins[i]);
			if(ans != Integer.MAX_VALUE)
				mini = Math.min(mini,1+ ans);
		}
		return mini;
	}
	public static void main(String[] args) {
			
		System.out.println(coinMin(amount));
	}
}
//0 1 1 2 3 5 8
	 // 1 2 3 4 5