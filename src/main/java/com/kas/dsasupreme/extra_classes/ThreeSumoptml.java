package com.kas.dsasupreme.extra_classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 
 * 
 * Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]] Example 2:
 * 
 * Input: nums = [] Output: [] Example 3:
 * 
 * Input: nums = [0] Output: []
 */

public class ThreeSumoptml {

	static List<int[]> threeSum(int[] nums) {
		List<int[]> res = new ArrayList<int[]>();
		List<List<Integer>> resl = new ArrayList();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int lo = i + 1;
				int hi = nums.length - 1;

				while (lo < hi) {

					if (nums[lo] + nums[hi] == -nums[i]) {
						res.add(new int[] { nums[i], nums[lo], nums[hi] });
						resl.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
						while(lo < hi && nums[lo] == nums[lo+1])lo++;
						while(lo < hi && nums[hi] == nums[hi-1])hi--;
						lo++;
						hi--;
					} else if (nums[lo] + nums[hi] < -nums[i])
						lo++;
					else
						hi--;
				}
			}
		}
		return res;

	}

	public static void main(String[] args) {
		//int[] nums = new int[] { -1, 0, 1, 2, -1, -4, -1, 2, 1 };
		/**
		 * Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
		 */
		int[] nums = new  int[]{-1,0,1,2,-1,-4};
		List<int[]> lsa = new ArrayList<>();
		if(nums.length != 0){
		 lsa = threeSum(nums);
		}
		else
			lsa.add(new int[]{});
		
		//List<int[]> lsadup = lsa.stream().distinct().collect(Collectors.toList());
		// Set<int[]> setlsa = lsa.stream().collect(Collectors.toSet());
		for (int[] a : lsa) {
			System.out.println(Arrays.toString(a));
		}
	}
}