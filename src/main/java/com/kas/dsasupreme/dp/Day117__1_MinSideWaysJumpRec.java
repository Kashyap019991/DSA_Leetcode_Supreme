package com.kas.dsasupreme.dp;

public class Day117__1_MinSideWaysJumpRec {
	// pos //0, 1,2,3,4
	static int[] obstacles = new int[] { 0, 1, 2, 3, 0 };
	static int n = obstacles.length-1;

	static int countDearr(int currlane, int currpos) {
		// here if frog reaches to 4 then stop
		if (currpos == n)
			return 0;

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
			return ans;
		}

	}

	public static void main(String[] args) {

		System.out.println(countDearr(2, 0));
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5