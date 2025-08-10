package com.kas.dsasupreme.dp;

import java.util.Arrays;

public class Day139__2_WildCardPatternMatchingRecMem {
	static int solveRecMem(String s, String p, int i, int j,int[][] dp) {
		// base case
		// 1. both consumed
		if (i < 0 && j < 0)
			return 1;
		// 2. pat consumed but str not
		if (i >= 0 && j < 0)
			return 0;
		// 3. str consumed but pat not then check for *
		if (i < 0 && j >= 0) {
			for (int k = 0; k <= j; k++) {
				if (p.charAt(k) != '*')
					return 0;
			}
			return 1;
		}

		if(dp[i][j] != -1) 
			{return dp[i][j];}
		// match
		if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
			{
				return dp[i][j] = solveRecMem(s, p, i - 1, j - 1,dp);
				
			}
		} else if (p.charAt(j) == '*') { // * repl with empty str in pat || *
											// repl with *anystr
			return dp[i][j] = solveRecMem(s, p, i, j - 1,dp) | solveRecMem(s, p, i - 1, j,dp);
			
		} else
			return 0;
	}

	public static void main(String[] args) {
		// Convert w1 -> w2
		//String s = "aa", p = "*"; // ans =true
		//String s = "aa", p = "a"; //ans =false
		String s = "cb", p = "?a"; //ans = false
		int[][] dp = new int[s.length()+1][p.length()+1];
		for(int i=0;i<=s.length();i++)
			Arrays.fill(dp[i], -1);
		System.out.println(solveRecMem(s, p, s.length() - 1, p.length() - 1,dp) ==1 ? true:false);
	}
}
