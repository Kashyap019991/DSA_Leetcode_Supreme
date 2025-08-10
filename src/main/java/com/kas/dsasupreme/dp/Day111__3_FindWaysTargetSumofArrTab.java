package com.kas.dsasupreme.dp;

public class Day111__3_FindWaysTargetSumofArrTab {

	/*static int target = 3;
	static int[] arr = new int[] { 1, 2 };*/
	// value
	
	 static int target = 4; 
	 static int[] arr = new int[] { 1, 2 ,3};// value
	 static int[] dp = new int[target + 1];

	static int countDearr(int targetN) {

		/*
		 * if (targetN == 0) return 1;
		 */
		dp[0] = 1;
		

		int ans = 0;
		//target travese 1to tar
		for (int i = 1; i <= targetN; i++) {
			//traverse each number for given target
			for (int j = 0; j < arr.length; j++) {
				if (i - arr[j] >= 0)
					dp[i] = dp[i] + dp[i - arr[j]];
			}
		}
		
		return dp[target];

	}

	public static void main(String[] args) {
		for (int i = 0; i <= target; i++)
			dp[i] = 0;
		System.out.println(countDearr(target));

	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5