package com.kas.dsasupreme.dp;

import java.util.HashMap;

public class Day125__2_LongestArtSeqRecMem {
	static int solveMem(int[] nums, int diff, int index,HashMap<Integer,Integer>[] dp) {
		// backward check
		if (index <= 0)
			return 0;
		
		if(dp[index].get(diff) != null) return dp[index].get(diff);
		int ans = 0;
		for (int j = index - 1; j >= 0; j--) {
			if (nums[index] - nums[j] == diff)
				ans = Math.max(ans, 1 + solveMem(nums, diff, j, dp));
		}
		//list.add()
		dp[index].put(diff, ans);
		return ans;
	}

	static int longestArthSeqMem(int[] nums, int n) {
		
		//Map<Integer,Integer>[] dp = new HashMap<>();
		//List<Map<Integer, Integer>> list = new ArrayList<Map<Integer, Integer>>();
		 HashMap<Integer,Integer>[] dp = new HashMap[nums.length+1];
		 for(int i = 0;i<=n;i++){
			 dp[i] = new HashMap<>();
		 }
		if (n <= 2)
			return n;
		
		int ans = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				ans = Math.max(ans, 2 + solveMem(nums, nums[j] - nums[i], i,dp));
			}
		}
		return ans;

	}

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 6, 9, 12 };
		int n = nums.length;

		System.out.println(longestArthSeqMem(nums, n));
	}
}
