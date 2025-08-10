package com.kas.dsasupreme.extra_classes;

import java.util.Arrays;

public class DoubleBasePalindrome {
	
static boolean checkBinary(int i){
		
		//int i= Integer.parseInt(s);
		String str ="";
		int n=i,d = 12345;
		//585%2 =? %2
		/**
n/2	  n	d * 
5/2 = 2	1
2/2 = 1	0
1/2 = 0	1
		 */
				while(n!=0){
				d = n%2;
				n = n/2;
				str += d;
				}
				
		if(str.equals(new StringBuilder().append(str).reverse().toString())){
			return true;
		}
		else
			return false;
	}
	public static void main(String[] args) {
		String s = "5";
		int sum =0;
		int n=Integer.parseInt(s);
		//StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++){
			//boolean b =;
		if(String.valueOf(i).equals(new StringBuilder().append(String.valueOf(i)).reverse().toString())){
			
			if(checkBinary(i))
			{
				sum +=i;
			}
		
		}
	}
		
		System.out.println(sum);

		
	}
}
