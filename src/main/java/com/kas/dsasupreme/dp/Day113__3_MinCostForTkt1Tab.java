package com.kas.dsasupreme.dp;

public class Day113__3_MinCostForTkt1Tab {

	static int[] days = new int[] { 2, 5 };
	static int[] cost = new int[] { 1, 4, 25 }; //ans =2 
	
	 
	
	 /* static int[] days = new int[]{1,4,6,7,8,20}; 
	  static int[] cost = new int[]{2,7,15}; //ans=11
	 */

	
	 /*static int[] days = new int[]{1,2,3,4,5,6,7,8,9,10,30,31}; 
	 static int[] cost = new int[]{2,7,15}; //ans =17
	*/
	static int n = days.length;
	static int dp[] = new int[n + 1];
	static int countDearr() {

		/*
		 * if (indx >= n) return 0;
		 */
		dp[n] = 0;
		// will do rev loop

		for (int k = n - 1; k >= 0; k--) {

			int opt1 = cost[0] + dp[k + 1];

			int i;
			for (i = k; i < n && days[i] < days[k] + 7; i++);
			int opt2 = cost[1] + dp[i];

			for (i = k; i < n && days[i] < days[k] + 30; i++);
			int opt3 = cost[2] + dp[i];

			// only 1 parmeter changing while calling above fun inx so 1-d dp
			dp[k] = Math.min(opt1, Math.min(opt2, opt3));
		}
		return dp[0];
	}

	public static void main(String[] args) {
		for (int i = 0; i <= n; i++) {
			// in above func we are finding Min so, initializa with INT_MAX
			dp[i] = Integer.MAX_VALUE;
		}
		System.out.println(countDearr());
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5