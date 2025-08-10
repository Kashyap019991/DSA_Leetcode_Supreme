package com.kas.dsasupreme.dp;

public class Day123__2_PartitionEqualSUbsetSumRecMem {

	static int countDearr(int index, int target, int[] nums, int n,int[][] dp) {

		if (target < 0)
			return 0;
		if (index >= n)
			return 0;
		if (target == 0)
			return 1;

		if(dp[index][target] != -1) return dp[index][target];
		int inc = countDearr(index + 1, target - nums[index], nums, n,dp);
		int exc = countDearr(index + 1, target - 0, nums, n,dp);

		return dp[index][target] = inc | exc;
	}

	public static void main(String[] args) {
		//int[] nums = new int[]{1,5,11,5}; // 1
		//int[] nums = new int[]{1,2,5}; // 0
		int[] nums = new int[] { 1, 2, 3, 5 };
		int total = 0;
		for (int i = 0; i < nums.length; i++)
			total = total + nums[i];
		if ((total | 1) <= total) // bcoz for even no. it will be > means +1
			return;
		total = total / 2;
		int n = nums.length;

		int[][] dp = new int[n + 1][total + 1];
		for(int i = 0 ; i<=n;i++){
			for(int j = 0; j<= total; j++){
				dp[i][j] = -1;
			}
		}
		System.out.println(countDearr(0, total, nums, nums.length,dp));
		System.out.println();
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5