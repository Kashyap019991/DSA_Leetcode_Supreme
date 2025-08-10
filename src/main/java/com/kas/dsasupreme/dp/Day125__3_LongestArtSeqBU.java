package com.kas.dsasupreme.dp;

import java.util.HashMap;

public class Day125__3_LongestArtSeqBU {
	
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

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				int diff = nums[i] - nums[j];
				int cnt =1;
				
				//check if already ans present
				if(dp[j].get(diff) != null)
					cnt = dp[j].get(diff);
				
				dp[i].put(diff, 1+cnt);
				ans = Math.max(ans, dp[i].get(diff));
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
