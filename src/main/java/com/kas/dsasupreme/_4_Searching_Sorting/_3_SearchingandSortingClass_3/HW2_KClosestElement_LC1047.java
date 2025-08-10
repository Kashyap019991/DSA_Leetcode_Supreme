package com.kas.dsasupreme._4_Searching_Sorting._3_SearchingandSortingClass_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

//29. Divide Two Integers https://leetcode.com/problems/divide-two-integers/description/


public class HW2_KClosestElement_LC1047 {

	static int lowerBound(int[] nums, int x){
		
		int s =0;
		int e = nums.length-1;
		int mid = s +(e-s)/2;
		int ans =e;//// case : 3 5 8 10 k =2;x =15	22
		while(s <=e){
			if(nums[mid] >= x)
			{
				ans =mid;
				e = mid-1;
			}
			else if(x > nums[mid])
				s =mid+1;
			/*else
				s =mid=1;*/
			mid = s+(e-s)/2;
				
		}
		return ans;
	}
	static List<Integer> kClosest(int[] nums,int x, int k) {
        int h = lowerBound(nums,x); //find element index which is >= x
        System.out.println("h: " + h); 
        int l = h-1;
        while(k >0){
        	if(l<0) h++;// case {1,2,3,4,5}; x =-1 k =4
        	else if(h > nums.length) l--; // case {1,2,3,4,5}; x =3 k =4
        	else if(x- nums[l] > nums[h] -x){
        		h++;
        	}
        	else
        		l--;
        	k--;
        }
     
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i=l+1;i<h;i++){
        	ans.add(nums[i]);
        }
		return ans;
    }
	
	public static void main(String[] args) {

		int[] nums = {12,16,22,30,35,39,42,45,50,53,55,56}; //35
			//{1,2,3,4,5}; //3 
			
		int x = 35; //target
		int k =4; //window size
		System.out.println(kClosest(nums,x,k));
	}
}
