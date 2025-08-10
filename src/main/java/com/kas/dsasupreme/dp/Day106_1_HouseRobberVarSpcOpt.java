package com.kas.dsasupreme.dp;

public class Day106_1_HouseRobberVarSpcOpt {
//for circular house , first is nebr of last 
//or same as MaxSumNn adj
static int n =5;
static int[] ip = new int[]{2,7,9,3,1};
		//{ 1, 2, 9, 4, 5, 0, 4, 11, 6 };
		//{9,9,8,2};
	static int solve(int[] fOrSec){
		
		int prev2= fOrSec[0];
		int prev1 = Math.max(fOrSec[0],fOrSec[1]);
		int n1 = fOrSec.length;
		for(int i=2;i<n1;i++){
			int inc = prev2 + fOrSec[i];
			int exc = prev1 + 0;
			int curr = Math.max(inc, exc);
			prev2 = prev1;
			prev1 = curr;
		}
		return prev1;
	}
	public static void main(String[] args) {
		
		int[] first = new int[n-1];
		int[] second = new int[n-1];
		
		for(int i=0;i<n;i++)
		{
			if(i!=0){
				second[i-1] = ip[i];
			}
			if(i!=n-1){
				first[i] = ip[i];	
			}
			
		}
		int a = solve(first);
		int b = solve(second);
		System.out.println(Math.max(a, b));
	}
}
//0 1 1 2 3 5 8
	 // 1 2 3 4 5