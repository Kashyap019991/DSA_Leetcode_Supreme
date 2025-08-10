package com.kas.dsasupreme.dp;

import java.util.Arrays;

//Same as LCS
public class Day136__1_LongestPalindromicSubSeqTabSopt {
	static int solveRecTabSopt(String text1, String text2) {
		//space O(m)
		int[] curr = new int[text2.length()+1];
		int[] next = new int[text2.length()+1];
		
		Arrays.fill(curr, 0);
		Arrays.fill(next, 0);
		
		
		for (int i = text1.length() - 1; i >= 0; i--) {
			for (int j = text2.length() - 1; j >= 0; j--) {
				int ans = 0;
				if (text1.charAt(i) == text2.charAt(j))
					ans = 1 + next[j + 1];
				else
					ans = 0 + Math.max(next[j], curr[j + 1]);

				curr[j] = ans;
			}
			next = curr.clone();
		}
		return next[0];
	}

	public static void main(String[] args) {
		String text1 = "bbbab";  //ans 4
		StringBuilder input1 = new StringBuilder(text1);
		String text2 = input1.reverse().toString(); 
		
		System.out.println(solveRecTabSopt(text1, text2));
	}
}
