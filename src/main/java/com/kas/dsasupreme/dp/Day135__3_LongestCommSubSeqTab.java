package com.kas.dsasupreme.dp;

import java.util.Arrays;

public class Day135__3_LongestCommSubSeqTab {
	static int solveRecTab(String text1, String text2, int[][] dp) {
		StringBuilder sb =  new StringBuilder();
		for (int i = text1.length() - 1; i >= 0; i--) {
			for (int j = text2.length() - 1; j >= 0; j--) {
				int ans = 0;
				if (text1.charAt(i) == text2.charAt(j))
					{
					ans = 1 + dp[i + 1][j + 1];
					
					}
				else
					ans = 0 + Math.max(dp[i + 1][j], dp[i][j + 1]);

				dp[i][j] = ans;
			}
		}


		int index = dp[0][0];
	    int temp = index;

	    char[] lcs = new char[index];
	    //lcs[index] ;
	    String S1= text1;
	    String S2 = text2;
	    int i = 1, j = 1;
	    while (i <= text1.length()  && j <= text2.length()) {
	      if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
	        lcs[index-1] = S1.charAt(i - 1);

	        i++;
	        j++;
	        index--;
	      }

	      else if (dp[i - 1][j] < dp[i][j - 1])
	        i++;
	      else
	        j++;
	    }

	    // Printing the sub sequences
	    System.out.print("S1 : " + S1 + "\nS2 : " + S2 + "\nLCS: ");
//	    for (int k = 0; k <= temp; k++){
//	      System.out.print(lcs[k]);
//	    System.out.println("");
//	  }
	    System.out.println("op" + new StringBuilder(String.valueOf(lcs)).reverse().toString());

		return dp[0][0];
	}

	public static void main(String[] args) {
		String text1 = "abcde", text2 = "ace"; // ans =3
		// String text1 = "abc", text2 = "def"; //ans =0
		int[][] dp = new int[text1.length() + 1][text2.length() + 1];
		for (int i = 0; i <= text1.length(); i++)
			Arrays.fill(dp[i], 0);
		System.out.println(solveRecTab(text1, text2, dp));
	}
}
