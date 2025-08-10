package com.kas.dsasupreme.dp;

import java.util.Arrays;

public class Day139__4_WildCardPatternMatchingTab1BasedIndex2 {
	static Boolean solveTab(String s, String p, int[][] dp) {
		// base case
		// 1. both consumed
		// if (i == 0 && j == 0)
		// return true;
		dp[0][0] = 1;
		// 2. pat consumed but str not
		// if (i > 0 && j == 0)
		// return false;

		// 3. str consumed but pat not then check for *
		// if (i == 0 && j > 0)
		for (int j = 1; j <= p.length(); j++) {
			Boolean flag = true;
			for (int k = 1; k <= j; k++) {
				if (p.charAt(k - 1) != '*') {
					flag = false;
					break;
				}
			}
			dp[0][j] = flag ? 1 : 0;
		}

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= p.length(); j++) {
				if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
					{
						dp[i][j] = dp[i - 1][j - 1];
						
					}
				} else if (p.charAt(j - 1) == '*') { // * repl with empty str in
														// pat || *
														// repl with *anystr
					dp[i][j] = dp[i][j - 1] | dp[i - 1][j];
					
				} else
					dp[i][j] = 0;

			}
		}
		return dp[s.length()][p.length()]  == 1 ? true : false; 
	}

	public static void main(String[] args) {
		// Convert w1 -> w2
		//String s = "aa", p = "*"; // ans =true
		// String s = "aa", p = "a"; //ans =false
		 String s = "aa", p = "aa"; //ans = false
		int[][] dp = new int[s.length() + 1][p.length() + 1];
		for (int i = 0; i <= s.length(); i++)
			Arrays.fill(dp[i], 0);
		System.out.println(solveTab(s, p, dp));
	}
}
