package com.kas.dsasupreme._4_Searching_Sorting._3_SearchingandSortingClass_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//29. Divide Two Integers https://leetcode.com/problems/divide-two-integers/description/
public class HW1_kdiffpairBS {
	static int countKDifference(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        
        for(int i = 0;i< nums.length;i++){
            if(map.containsKey(nums[i]-k)){
                res+= map.get(nums[i]-k);
            }
            if(map.containsKey(nums[i]+k)){
                res+= map.get(nums[i]+k);
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        
        return res;
    }
	
	public static void main(String[] args) {
		/*
		 * Input: nums = [1,2,2,1], k = 1
Output: 4
Explanation: The pairs with an absolute difference of 1 are:
- [1,2,2,1]
- [1,2,2,1]
- [1,2,2,1]
- [1,2,2,1]
		 */
		int[] nums = {3,2,1,5,4};
		int k = 2;
		System.out.println(countKDifference(nums,k));
	}
}
