package com.kas.dsasupreme.dp;

public class Day117__4_MinSideWaysJumpSopt2col {
	// pos //0, 1,2,3,4
	//static int[] obstacles = new int[] { 0, 1, 2, 3, 0 }; // ans 2
	//static int[] obstacles = new int[] { 0,1,1,3,3,0}; //ans 0
	static int[] obstacles = new int[] { 0,2,1,0,3,0}; //ans 2
	static int n = obstacles.length - 1;
	// [3lane+1][n+1]

	static int countDearr() {
		// here if frog reaches to 4 then stop
		int[] curr = new int[4];
		int[] next = new int[4];
		for(int i = 0 ; i<4 ;i++)
		{
			curr[i] = Integer.MAX_VALUE;
			next[i] = Integer.MAX_VALUE;
		}
		next[0] = 0;
		next[1] = 0;
		next[2] = 0;
		next[3] = 0;

		// check if we move in same lane ahead
		// BU
		for (int currpos = n - 1; currpos >= 0; currpos--) {

			for (int currlane = 1; currlane <= 3; currlane++) {

				if (obstacles[currpos + 1] != currlane) {
					curr[currlane] =  next[currlane];
				} else {
					// jump sideway
					// before checke not in curr lane
					int ans = 100000000;
					for (int i = 1; i <= 3; i++) {
						if (i != currlane && obstacles[currpos] != i) {
							//catch 										+1 bcoz side cross due to obstacle
							ans = Math.min(ans, 1 + next[i]);
						}
					}
					curr[currlane] = ans;
				}
				
			}
			next = curr;
			
		}
		return Math.min(next[2], Math.min(1+next[1], 1+next[3]));
	}

	public static void main(String[] args) {
	
		System.out.println(countDearr());
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5