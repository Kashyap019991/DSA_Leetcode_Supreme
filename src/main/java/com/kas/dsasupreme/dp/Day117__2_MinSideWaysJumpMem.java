package com.kas.dsasupreme.dp;

public class Day117__2_MinSideWaysJumpMem {
	// pos //0, 1,2,3,4
	static int[] obstacles = new int[] { 0, 1, 2, 3, 0 };
	static int n = obstacles.length-1;
						//[3lane+1][n+1]
	static int[][] dp = new int[4][n+1];
	static int countDearr(int currlane, int currpos) {
		// here if frog reaches to 4 then stop
		if (currpos == n)
			return 0;
		if(dp[currlane][currpos] != -1) return dp[currlane][currpos];
		// check if we move in same lane ahead
		if (obstacles[currpos + 1] != currlane) {
			return countDearr(currlane, currpos + 1);
		} else {
			// jump sideway
			// before checke not in curr lane
			int ans = Integer.MAX_VALUE;
			for (int i = 1; i <= 3; i++) {
				if (i != currlane && obstacles[currpos] != i) {
					ans = Math.min(ans, 1 + countDearr(i, currpos));
				}
			}
			dp[currlane][currpos] = ans;
			return dp[currlane][currpos];
		}

	}

	public static void main(String[] args) {
		for(int i = 0; i< dp.length;i++)
		{
			for(int j=0;j< dp[0].length;j++)
				dp[i][j] = -1;
		}
		System.out.println(countDearr(2, 0));
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5