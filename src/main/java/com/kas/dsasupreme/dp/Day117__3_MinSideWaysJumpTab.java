package com.kas.dsasupreme.dp;

public class Day117__3_MinSideWaysJumpTab {
	// pos //0, 1,2,3,4
	//static int[] obstacles = new int[] { 0, 1, 2, 3, 0 }; // ans 2
	//static int[] obstacles = new int[] { 0,1,1,3,3,0}; //ans 0
	static int[] obstacles = new int[] { 0,2,1,0,3,0}; //ans 2
	static int n = obstacles.length - 1;
	// [3lane+1][n+1]
	static int[][] dp = new int[4][n + 1];

	static int countDearr() {
		// here if frog reaches to 4 then stop
		/*
		 * if (currpos == n) return 0;
		 */
		dp[0][n] = 0;
		dp[1][n] = 0;
		dp[2][n] = 0;
		dp[3][n] = 0;

		// check if we move in same lane ahead
		// BU
		for (int currpos = n - 1; currpos >= 0; currpos--) {

			for (int currlane = 1; currlane <= 3; currlane++) {

				if (obstacles[currpos + 1] != currlane) {
					dp[currlane][currpos] =  dp[currlane][currpos + 1];
				} else {
					// jump sideway
					// before checke not in curr lane
					int ans = 100000000;
					for (int i = 1; i <= 3; i++) {
						if (i != currlane && obstacles[currpos] != i) {
							//catch 										+1 bcoz side cross due to obstacle
							ans = Math.min(ans, 1 + dp[i][currpos+1]);
						}
					}
					dp[currlane][currpos] = ans;
				}
				
			}
			
		}
		return Math.min(dp[2][0], Math.min(1+dp[1][0], 1+dp[3][0]));
	}

	public static void main(String[] args) {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++)
				dp[i][j] = 100000000;
		}
		System.out.println(countDearr());
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5