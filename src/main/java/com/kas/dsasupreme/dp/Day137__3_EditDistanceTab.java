package com.kas.dsasupreme.dp;

//Count Min no of op to convert string a to b
public class Day137__3_EditDistanceTab {
	static int solveTab(String text1, String text2) {
		// base case
		// if(text1.length() == i) return text2.length() - j; //t1<t2
		// if(text2.length() == j) return text1.length() - i; // t1>te
		int[][] dp = new int[text1.length() + 1][text2.length() + 1];
		for (int j = 0; j <= text2.length(); j++)
			dp[text1.length()][j] = text2.length() - j;

		for (int i = 0; i <= text1.length(); i++)
			dp[i][text2.length()] = text1.length() - i;

		for (int i = text1.length() - 1; i >= 0; i--) {
			for (int j = text2.length() - 1; j >= 0; j--) {
				int ans = 0;
				if (text1.charAt(i) == text2.charAt(j))
					ans = dp[i + 1][j + 1];
				else {
					int insop = 1 + dp[i][j + 1];
					int replop = 1 + dp[i + 1][j + 1];
					int delop = 1 + dp[i + 1][j];

					ans = Math.min(insop, Math.min(replop, delop));
				}
				dp[i][j] = ans;
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		//multiple time b->s allowed
		
		String word1 = "horse", word2 = "ros"; //ans =3
		
			
		System.out.println(solveTab(word1, word2));
	}
}
