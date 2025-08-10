package com.kas.dsasupreme.dp;

public class Day109_1_NinjaFenceRec {
//for circular house , first is nebr of last 
//or same as MaxSumNn adj
static int n =4;//{0,1,2} ==> {1,0,2},{2,1,0},------
static int k =3;
static final int MOD = 1000000007; 
	static int countDearr(int n){
		
		if(n==1) return k;
		if(n==2) return (k * (k-1)) + k;
		
		int ans = ((countDearr(n-1)%MOD) + (countDearr(n-2)%MOD)) *(k-1);
		
		
		return ans;
	}
	public static void main(String[] args) {
		
		System.out.println(countDearr(n));
	}
}
//0 1 1 2 3 5 8
	 // 1 2 3 4 5