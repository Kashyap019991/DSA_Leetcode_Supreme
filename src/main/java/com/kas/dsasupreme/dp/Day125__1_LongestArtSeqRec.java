package com.kas.dsasupreme.dp;

public class Day125__1_LongestArtSeqRec {
	static int solve(int[] nums, int diff, int index) {
		// backward check
		if (index <= 0)
			return 0;

		int ans = 0;
		for (int j = index - 1; j >= 0; j--) {
			if (nums[index] - nums[j] == diff)
				ans = Math.max(ans, 1 + solve(nums, diff, j));
		}
		return ans;
	}

	static int longestArthSeq(int[] nums, int n) {
		if (n <= 2)
			return n;

		int ans = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				ans = Math.max(ans, 2 + solve(nums, nums[j] - nums[i], i));
			}
		}
		return ans;

	}

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 6, 9, 12 };
		int n = nums.length;

		System.out.println(longestArthSeq(nums, n));
	}
}
