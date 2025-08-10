package com.kas.dsasupreme.dp;
//https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

public class Day139__5_WildCardPatternMatchingTab1BasedIndexSopt {
	static Boolean solveRec(String s, String p, int i, int j) {
		// base case
		// 1. both consumed
		if (i < 0 && j < 0)
			return true;
		// 2. pat consumed but str not
		if (i >= 0 && j < 0)
			return false;
		// 3. str consumed but pat not then check for *
		if (i < 0 && j >= 0) {
			for (int k = 0; k <= j; k++) {
				if (p.charAt(k) != '*')
					return false;
			}
			return true;
		}

		// match
		if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
			return solveRec(s, p, i - 1, j - 1);
		} else if (p.charAt(j) == '*') { // * repl with empty str in pat || *
											// repl with *anystr
			return solveRec(s, p, i, j - 1) || solveRec(s, p, i - 1, j);
		} else
			return false;
	}

	public static void main(String[] args) {
		// Convert w1 -> w2
		//String s = "aa", p = "*"; // ans =true
		//String s = "aa", p = "a"; //ans =false
		String s = "cb", p = "?a"; //ans = false
		System.out.println(solveRec(s, p, s.length() - 1, p.length() - 1));
	}
}
