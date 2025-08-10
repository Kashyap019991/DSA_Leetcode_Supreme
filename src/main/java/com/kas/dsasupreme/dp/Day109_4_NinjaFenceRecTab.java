package com.kas.dsasupreme.dp;

public class Day109_4_NinjaFenceRecTab {
//for circular house , first is nebr of last 
//or same as MaxSumNn adj
static int n =4;//{0,1,2} ==> {1,0,2},{2,1,0},------
static int k =3;
static final int MOD = 1000000007;
static int[] dp = new  int[n+1];
	static int countDearr(int n){
		
		//if(n==1) return k;
		int prev2 = k;
		//if(n==2) return (k * (k-1)) + k;
		int prev1 = k * (k-1) + k;
		
		/*if(dp[n] != -1)
			return -1;*/
		
		for(int i=3; i<=n;i++)
		{
			int curr = ((prev1%MOD) * (k-1)) + ((prev2%MOD) *(k-1));
			prev2 = prev1;
			prev1 = curr;
		}
		//dp[n] = ((countDearr(n-1)%MOD) *(k-1)) + ((countDearr(n-2)%MOD)* (k-1));
		
		
		return prev1;
	}
	public static void main(String[] args) {
		for(int i = 0; i<=n;i++)
			dp[i] = -1;
		System.out.println(countDearr(n));
	}
}
//0 1 1 2 3 5 8
	 // 1 2 3 4 5