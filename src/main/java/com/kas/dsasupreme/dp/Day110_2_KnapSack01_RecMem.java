package com.kas.dsasupreme.dp;

public class Day110_2_KnapSack01_RecMem {
	// for circular house , first is nebr of last
	// or same as MaxSumNn adj
	/*static int n = 4;// {0,1,2} ==> {1,0,2},{2,1,0},------
	static int capacity = 5;
	static int[] w = new int[] { 1, 2, 4, 5 };// weight
	static int[] v = new int[] { 5, 4, 8, 6 };// value
*/	static final int MOD = 1000000007;
	
	static int n = 3;// {0,1,2} ==> {1,0,2},{2,1,0},------
	static int capacity = 50;
	static int[] w = new int[] { 10, 20, 30 };// weight
	static int[] v = new int[] { 60, 100, 120 };// valu
	
	static int[][] dp = new int[n + 1][capacity + 1];

	static int countDearr(int indx, int capac) {

		if (indx == 0) {
			if (w[0] <= capac)
				return v[0];
			else
				return 0;
		}
		
		if(dp[indx][capac] != -1) return dp[indx][capac];
		int inc = 0;
		if(w[indx] <= capac)
			inc = v[indx] + countDearr(indx-1, capac - w[indx]);
		
		int exc = 0 + countDearr(indx-1, capac);
		
		 dp[indx][capac]= Math.max(inc, exc);
		
		return dp[indx][capac];
	}

	
	
	public static void main(String[] args) {
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= capacity; j++)
				dp[i][j] = -1;
		}
		System.out.println(countDearr(n - 1, capacity));
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5