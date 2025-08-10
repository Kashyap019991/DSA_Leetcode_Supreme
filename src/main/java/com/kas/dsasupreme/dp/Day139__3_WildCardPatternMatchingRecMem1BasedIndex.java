package com.kas.dsasupreme.dp;

import java.util.Arrays;

public class Day139__3_WildCardPatternMatchingRecMem1BasedIndex {
	static Boolean solveRecMem(String s, String p, int i, int j,int[][] dp) {
		// base case
		// 1. both consumed
		if (i == 0 && j == 0)
			return true;
		// 2. pat consumed but str not
		if (i > 0 && j == 0)
			return false;
		// 3. str consumed but pat not then check for *
		if (i == 0 && j > 0) {
			for (int k = 1; k <= j; k++) {
				if (p.charAt(k-1) != '*')
					return false;
			}
			return true;
		}

		if(dp[i][j] != -1) 
			{if(dp[i][j] == 1) return true; else return false;}
		// match
		if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
			{
				dp[i][j] = solveRecMem(s, p, i - 1, j - 1,dp)?1:0;
				return (dp[i][j] ==1) ? true : false;
			}
		} else if (p.charAt(j-1) == '*') { // * repl with empty str in pat || *
											// repl with *anystr
			dp[i][j] = solveRecMem(s, p, i, j - 1,dp) || solveRecMem(s, p, i - 1, j,dp) ?1:0;
			return (dp[i][j] ==1) ? true : false;
		} else
			return false;
	}

	public static void main(String[] args) {
		// Convert w1 -> w2
		String s = "aa", p = "*"; // ans =true
		//String s = "aa", p = "a"; //ans =false
		//String s = "cb", p = "?a"; //ans = false
		int[][] dp = new int[s.length()+1][p.length()+1];
		for(int i=0;i<=s.length();i++)
			Arrays.fill(dp[i], -1);
		System.out.println(solveRecMem(s, p, s.length(), p.length(),dp));
	}
}
