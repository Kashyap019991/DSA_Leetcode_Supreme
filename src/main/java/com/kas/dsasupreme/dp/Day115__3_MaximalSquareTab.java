package com.kas.dsasupreme.dp;

public class Day115__3_MaximalSquareTab {

	static int[][] ip = new int[][] { { 1, 1 }, { 1, 1 } };
	// static int[][] ip = new int[][]{{0,1},{1,0}};
	// static int[][] ip = new
	// int[][]{{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
	static int maxim = 0;
	static int m = ip.length;// row
	static int n = ip[0].length; // cols
	static int[][] dp = new int[m+1][n+1];

	static int countDearr() {

		// if (j >= ip[0].length || i >= ip.length) return 0;

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int right = dp[i][j + 1];
				int diagnal = dp[i + 1][j + 1];
				int down = dp[i + 1][j];

				if (ip[i][j] == 1) {
					dp[i][j] = 1 + Math.min(right, Math.min(diagnal, down));
					maxim = Math.max(maxim, dp[i][j]);

				} else
					dp[i][j] = 0;
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				dp[i][j] = 0;
			}
		}

		countDearr();
		System.out.println(maxim);
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5