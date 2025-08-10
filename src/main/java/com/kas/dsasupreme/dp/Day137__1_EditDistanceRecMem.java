package com.kas.dsasupreme.dp;

import java.util.Arrays;

//Count Min no of op to convert string a to b
public class Day137__1_EditDistanceRecMem {
	 static int solveRecMem(String text1, String text2,int i, int j,int[][] dp){
	     //base case
		 if(text1.length() == i) return text2.length() - j; //t1<t2
		 if(text2.length() == j) return text1.length() - i; // t1>te
		 
		 if(dp[i][j] !=-1) return dp[i][j];
		 int ans =0;
		 if(text1.charAt(i) == text2.charAt(j))
			 ans = solveRecMem(text1,text2,i+1,j+1,dp);
		 else
		 {
			int insop = 1 + solveRecMem(text1, text2, i, j+1,dp);
			int replop = 1+ solveRecMem(text1, text2, i+1, j+1,dp);
			int delop = 1 + solveRecMem(text1, text2, i+1, j,dp);
			
			ans = Math.min(insop, Math.min(replop, delop));
		 }
		 return dp[i][j] = ans;
	    }
	public static void main(String[] args) {
		//multiple time b->s allowed
		//String text1 = "abc", text2 = "abc"; //ans =3
		String word1 = "horse", word2 = "ros"; //ans =0
		int[][] dp = new int[word1.length()+1][word2.length()+1];
		for(int i=0;i<=word1.length();i++)
			Arrays.fill(dp[i], -1);
		System.out.println(solveRecMem(word1, word2,0,0,dp));
	}
}
