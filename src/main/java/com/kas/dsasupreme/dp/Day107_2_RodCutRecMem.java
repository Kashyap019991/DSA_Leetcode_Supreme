package com.kas.dsasupreme.dp;

public class Day107_2_RodCutRecMem {

static int t =7;
static int n = 3,x=5,y=2,z=2;

	public static int rodCutMax(int i){
		//base case
		//if(i== 0) return ip[i];
		if(i<0) return Integer.MIN_VALUE;
		if(i == 0) return 0;
		
		
		int a = rodCutMax(i-x) + 1;
		int b = rodCutMax(i-y) + 1;
		int c = rodCutMax(i-z) + 1;
		
		return Math.max(a,Math.max(b, c));		
		
	}
	public static void main(String[] args) {
		
		System.out.println(rodCutMax(t));
	}
}
//0 1 1 2 3 5 8
	 // 1 2 3 4 5