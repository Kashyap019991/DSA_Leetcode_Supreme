package com.kas.dsasupreme.dp;

import java.util.HashMap;

public class Day126__3_LongestArtSeqWithDiffdBU {
	
	static int longestArthSeqMem(int[] nums, int diff) {
		
		//Map<Integer,Integer>[] dp = new HashMap<>();
		//List<Map<Integer, Integer>> list = new ArrayList<Map<Integer, Integer>>();
		 HashMap<Integer,Integer> dp = new HashMap();
		 
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			int temp = nums[i] - diff;
			int tempAns = 0;
			
			if(dp.get(temp) != null)
				tempAns = dp.get(temp);
			
			dp.put(nums[i], 1+tempAns);
			
			ans = Math.max(ans, dp.get(nums[i]));
		}
		return ans;

	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1,3,5,7 }; //ans 1
		int n = nums.length;
		int diff = 1;
		System.out.println(longestArthSeqMem(nums, diff));
	}
}
