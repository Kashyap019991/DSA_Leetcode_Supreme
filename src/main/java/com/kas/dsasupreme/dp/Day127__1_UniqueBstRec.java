package com.kas.dsasupreme.dp;

public class Day127__1_UniqueBstRec {
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

	static int uniqueBst(int n) {
		if (n <= 1)
			return 1;

		int ans = 0;

		for (int i = 1; i <= n; i++) {
			
			ans = ans + (uniqueBst(i-1) * uniqueBst(n-i));
		}
		return ans;

	}

	public static void main(String[] args) {

		int n = 3;

		System.out.println(uniqueBst(n));
	}
}
