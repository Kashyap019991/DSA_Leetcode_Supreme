package com.kas.dsasupreme.dp;

public class Day110_3_KnapSack01_RecTab1 {
	// for circular house , first is nebr of last
	// or same as MaxSumNn adj
	
	  static int n = 4;// {0,1,2} ==> {1,0,2},{2,1,0},------ static int
	  static int capacity = 5; 
	  static int[] w = new int[] { 1, 2, 4, 5 };// weight static
	  static int[] v = new int[] { 5, 4, 8, 6 };// value
	 
	/*
	 * static int n = 6;// {0,1,2} ==> {1,0,2},{2,1,0},------ static int
	 * capacity = 10; static int[] w = new int[] { 1, 2, 3, 8, 7, 4 };// weight
	 * static int[] v = new int[] { 20, 5, 10, 40, 15, 25 };// value
	 */

	/*static int n = 3;// {0,1,2} ==> {1,0,2},{2,1,0},------
	static int capacity = 50;
	static int[] w = new int[] { 10, 20, 30 };// weight
	static int[] v = new int[] { 60, 100, 120 };// value
*/
	static int[][] dp = new int[n + 1][capacity + 1];

	static int countDearr(int indx, int capac) {

		// if (indx == 0) {
		for (int i = w[0]; i <= capac; i++) {
			if (w[0] <= capac)
				dp[0][i] = v[0];
			/*else
				dp[0][i] = 0;*/
		}

		// if(dp[indx][capac] != -1) return dp[indx][capac];

		for (int i = 1; i < indx; i++) {
			for (int j = 0; j <= capac; j++) {
				int inc = 0;
				if (w[i] <= j)
					inc = v[i] + dp[i - 1][j - w[i]];

				int exc = 0 + dp[i - 1][j];

				dp[i][j] = Math.max(inc, exc);

			}
		}
		return dp[indx - 1][capac];
	}

	public static void main(String[] args) {
		/*
		 * for (int i = 0; i <= n; i++) { for (int j = 0; j <= capacity; j++)
		 * dp[i][j] = -1; }
		 */
		System.out.println(countDearr(n, capacity));
	}

	/*
	 * // Input: // Values (stored in array `v`) // Weights (stored in array
	 * `w`) // Total number of distinct items `n` // Knapsack capacity `W`
	 * public static int knapsack(int[] v, int[] w, int W) { // `T[i][j]` stores
	 * the maximum value of knapsack having weight // less than equal to `j`
	 * with only first `i` items considered. int[][] T = new int[v.length + 1][W
	 * + 1];
	 * 
	 * // do for i'th item for (int i = 1; i <= v.length; i++) { // consider all
	 * weights from 0 to maximum capacity `W` for (int j = 0; j <= W; j++) { //
	 * don't include the i'th element if `j-w[i-1]` is negative if (w[i-1] > j)
	 * { T[i][j] = T[i-1][j]; } else { // find the maximum value we get by
	 * excluding or including // the i'th item T[i][j] = Integer.max(T[i-1][j],
	 * T[i-1][j-w[i-1]] + v[i-1]); } } }
	 * 
	 * // return maximum value return T[v.length][W]; }
	 * 
	 * public static void main(String[] args) { // input: a set of items, each
	 * with a weight and a value int[] v = { 60,100,120 }; int[] w = { 10,20,30
	 * };
	 * 
	 * // knapsack capacity int W = 50;
	 * 
	 * System.out.println("Knapsack value is " + knapsack(v, w, W)); }
	 */
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5