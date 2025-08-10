package com.kas.dsasupreme.dp;

public class Day123__4_PartitionEqualSUbsetSumBUTabSopt {

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

		int[] curr = new int[total + 1];
		int[] next = new int[total + 1];

		curr[0] = 1;
		next[0] = 1;
		
		for (int index = n - 1; index >= 0; index--) {
			for (int target = 0; target <= total / 2; target++) {
				int inc = 0;
				if (target - nums[index] >= 0)
					inc = next[target - nums[index]];
				int exc = next[target - 0];

				curr[target] = inc | exc;

			}
			next = curr.clone();
		}
		return next[total / 2];
	}

	public static void main(String[] args) {
		// int[] nums = new int[]{1,5,11,5}; //1
		int[] nums = new int[] { 1, 2, 5 };// 0
		//int[] nums = new int[] { 1, 2, 3, 5 }; // 0

		System.out.println(countDearr(nums));
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5