package com.kas.dsasupreme.recursion;

public class Day1_Fibo {
static int res;
	public static int fibo(int n){
		
		
		//base case
		if(n==0)return 0;
		if(n==1)return 1;
		
		res = fibo(n-1) + fibo(n-2);
		return res;
	}
	public static void main(String[] args) {
		
		System.out.println(fibo(6));
	}
}
//0 1 1 2 3 5 8
	 // 1 2 3 4 5