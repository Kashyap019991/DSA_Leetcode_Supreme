package com.kas.dsasupreme._4_Searching_Sorting._3_SearchingandSortingClass_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//29. Divide Two Integers https://leetcode.com/problems/divide-two-integers/description/
public class HW1_countKDifference_LC_2006 {
	static int binarySearch(int[] nums,int s, int target){
		int e = nums.length -1;
		int mid = s + (e-s) /2;
		
		while(s <= e){
			if(target == nums[mid]){
				return mid;
			}
			else if(target < nums[mid])
				e = mid-1;//left
			else 
				s = mid+1; //right
			mid = s + (e-s) /2;
		}
		return -1;
	}
	static int findPairs(int[] nums, int k) {
        //sort kr lo
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		Set<List<Integer>> ans = new HashSet<List<Integer>>();
		for(int i=0;i<nums.length;i++){
			if(binarySearch(nums,i+1,nums[i]+k) != -1){//a[i] ke liye a[i] +k mil gya
				//System.out.println(nums[i]  +"  "+ Math.addExact(nums[i],k));
				ans.add(Arrays.asList(nums[i],nums[i]+k));
			}
		}
		//System.out.println(ans);
		return ans.size();
    }

	public static void main(String[] args) {
		int[] nums = {3,1,4,1,5};
		int k = 2;
		System.out.println(findPairs(nums,k));
	}
}
