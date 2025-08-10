package com.kas.dsasupreme.extra_classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 
 * 
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []
 */

public class ThreeSumbrtfrc{
	
	static List<int[]> threeSum(int[] nums){
		List<int[]> lsa = new ArrayList<int[]>();
		for(int i=0;i<nums.length;i++){
			for(int j=i+1;j<nums.length;j++){
				for(int k=j+1;k<nums.length;k++){
					if(nums[i]+nums[j]+nums[k] == 0){
						lsa.add(new int[]{nums[i],nums[j],nums[k]});
					}
				}
			}
		}
		
		return lsa;
		
	}
	public static void main(String[] args) {
		int[] nums = new int[]{-1,0,1,2,-1,-4,-1,2,1};
		List<int[]> lsa=threeSum(nums);
		Set<int[]> setlsa = lsa.stream().collect(Collectors.toSet());
		for(int[] a:setlsa){
			System.out.println(Arrays.toString(a));
		}
	}
}