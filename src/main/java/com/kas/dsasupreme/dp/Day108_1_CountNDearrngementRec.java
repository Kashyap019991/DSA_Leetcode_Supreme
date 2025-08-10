package com.kas.dsasupreme.dp;

public class Day108_1_CountNDearrngementRec {
//for circular house , first is nebr of last 
//or same as MaxSumNn adj
static int n =4;//{0,1,2} ==> {1,0,2},{2,1,0},------
static final int MOD = 1000000007; 
	static int countDearr(int n){
		
		if(n==1) return 0;
		if(n==2) return 1;
		
		int ans = ((n-1)%MOD) * ((countDearr(n-1)%MOD) + (countDearr(n-2)%MOD));
		
		
		return ans;
	}
	public static void main(String[] args) {
		
		System.out.println(countDearr(n));
	}
}
//0 1 1 2 3 5 8
	 // 1 2 3 4 5