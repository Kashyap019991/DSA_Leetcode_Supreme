package com.kas.dsasupreme.extra_classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//twosum 
/**
 * 
 * Example 1:
 * 
 * Input: nums = [2,7,3,6], target = 9 Output: [0,1] Explanation: Because
 * nums[0] + nums[1] == 9, we return [0, 1]. Example 2:
 * 
 * Input: nums = [3,2,4], target = 6 Output: [1,2] Example 3:
 * 
 * Input: nums = [3,3], target = 6 Output: [0,1]
 */

public class TwoSum {
	public static List<int[]> twoSum(int[] nums, int target) {

		List<int[]> lsa = new ArrayList<>();
		Map<Integer, Integer> hm = new HashMap<>();
		int[] res = new int[2];
		
		for (int i = 0; i < nums.length; i++) {
			int k=0;
			if (hm.get(target - nums[i]) != null) {
					res[0] = hm.get(target - nums[i]).intValue();
					k++;
					res[1] = i;
					//k++;
					lsa.add(new int[]{ hm.get(target - nums[i]).intValue(),i});
			}
			hm.put(nums[i], i);
		}
		return lsa;

	}

	public static void main(String[] args) {

		int[] nums = new int[] { 2, 7, 3, 6 };
		int target = 9;
		List<int[]> lsa =twoSum(nums, target);
		//System.out.println(Arrays.toString(twoSum(nums, target)));
		for(int[] a:lsa){
			System.out.println(Arrays.toString(a));
		}
	}
}