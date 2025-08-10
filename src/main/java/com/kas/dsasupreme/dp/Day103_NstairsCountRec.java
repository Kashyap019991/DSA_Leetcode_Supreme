package com.kas.dsasupreme.dp;

public class Day103_NstairsCountRec {
static int res;
static int count=0;
	public static int nStairs(int n){
		
		
		//base case
		if(n<0)return 0;
		if(n==0)
			{count++;
			return 1;
					}
		
		res = nStairs(n-1) + nStairs(n-2);
		return res;
	}
	public static void main(String[] args) {
		int count = 0;	
		System.out.println(nStairs(3));
	}
}
//0 1 1 2 3 5 8
	 // 1 2 3 4 5