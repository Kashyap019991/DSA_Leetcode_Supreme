package com.kas.dsasupreme.dp;

public class Day116__1_MinScoreTriangleRec {
	//static int[] ip = new int[]{1,2,3}; //ans = 6
	static int[] ip = new int[]{5,3,7,4};  //ans =144
	//static int maxim = 0;
	static int n = ip.length;
	static int countDearr(int i,int j) {

		if(i+1 == j) return 0;
		
		int ans = Integer.MAX_VALUE;
		
		for(int k= i+1; k<j;k++){
			ans = Math.min(ans,((ip[i]*ip[j]*ip[k]) + countDearr(i, k) + countDearr(k, j)));
			
		}
		return ans;
	}

	public static void main(String[] args) {
		
		System.out.println(countDearr(0,n-1));
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5