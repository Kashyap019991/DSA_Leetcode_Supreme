package com.kas.dsasupreme.dp;

//Count Min no of op to convert string a to b
public class Day139__1_1_WildCardPatternMatchingRec1Baseind {
	static Boolean solveRec(String s, String p, int i, int j) {
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

		// match
		if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
			return solveRec(s, p, i - 1, j - 1);
		} else if (p.charAt(j-1) == '*') { // * repl with empty str in pat || *
											// repl with *anystr
			return solveRec(s, p, i, j - 1) || solveRec(s, p, i - 1, j);
		} else
			return false;
	}

	public static void main(String[] args) {
		// Convert w1 -> w2
		String s = "aa", p = "*"; // ans =true
		//String s = "aa", p = "a"; //ans =false
		//String s = "cb", p = "?a"; //ans = false
		System.out.println(solveRec(s, p, s.length(), p.length()));
	}
}
