package com.kas.dsasupreme.dp;

public class Day1_SayDigits {
static String res ="";
static String[] s = {"zero","one","two","three","four"};
	public static void sayDigits(int n){
		
		if(n==0) return;
		int digit = n%10;
		
		n=n/10;
		sayDigits(n);
		res = res +s[digit] +" ";
	}
	public static void main(String[] args) {
		int count = 0;	
		sayDigits(412);
		System.out.println(res);
	}
}
//412
//41
//4
//0
	 // 1 2 3 4 5