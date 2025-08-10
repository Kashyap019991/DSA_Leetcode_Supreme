package com.kas.dsasupreme.dp;

import java.util.Arrays;

public class Day135__2_LongestCommSubSeqRecMem {
	 static int solveRec(String text1, String text2,int i, int j, int[][] dp){
	     //base case
		 if(text1.length() == i) return 0;
		 if(text2.length() == j) return 0;
		 if(dp[i][j] != -1) return dp[i][j];
		 int ans =0;
		 if(text1.charAt(i) == text2.charAt(j))
			 ans = 1 + solveRec(text1,text2,i+1,j+1,dp);
		 else
			 ans = 0 + Math.max(solveRec(text1,text2,i+1,j,dp), solveRec(text1,text2,i,j+1,dp));
		 
	        return dp[i][j] = ans;
	    }
	public static void main(String[] args) {
		String text1 = "abc", text2 = "abc"; //ans =3
		//String text1 = "abc", text2 = "def"; //ans =0
		int[][] dp = new int[text1.length()+1][text2.length()+1];
		for(int i=0;i<=text1.length();i++)
			Arrays.fill(dp[i], -1);
		System.out.println(solveRec(text1, text2,0,0,dp));
	}
}
