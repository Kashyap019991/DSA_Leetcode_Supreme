package com.kas.dsasupreme.dp;

public class Day123__3_PartitionEqualSUbsetSumBUTab {

	static int countDearr(int[] nums) {

		/*
		 * if (target < 0) return 0; if (index >= n) return 0;
		 */
		int total = 0;
		for (int i = 0; i < nums.length; i++)
			total = total + nums[i];
		if ((total | 1) <= total) // bcoz for even no. it will be > means +1
			return 0;

		int n = nums.length;

		int[][] dp = new int[n + 1][(total) + 1];
		for (int i = 0; i <= n; i++) {

			dp[i][0] = 1;

		} /*
			 * if (target == 0) return 1;
			 */

		for (int index = n-1; index >= 0; index--) {
			for (int target = 0; target <= total / 2; target++) {
				int inc = 0;
				if(target - nums[index] >= 0)
				inc = dp[index + 1][target - nums[index]];
				int exc = dp[index + 1][target - 0];

				dp[index][target] = inc | exc;

			}
		}
		return dp[0][total / 2];
	}

	public static void main(String[] args) {
		//int[] nums = new int[]{1,5,11,5}; //1
		int[] nums = new int[] { 1, 2, 5 };// 0
		//int[] nums = new int[] { 1, 2, 3, 5 }; //0

		System.out.println(countDearr(nums));
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5