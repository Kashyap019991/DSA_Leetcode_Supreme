package com.kas.practice_javadsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class WidestPairOfIdicesWithMaxSum {
    static int ans =  Integer.MAX_VALUE;
    
    public static int widestPair(int[] nums1, int[] nums2) {
       //j-i+1
    	//int i=0,j=1;
    	
    	//while(j<=i) {
    		//i=0;j=1,2,3
    		//i=1,j=2,3
    	//}
		/*
		 * int ind=0; for(int i=0;i<nums1.length;i++) {
		 * 
		 * for(int j=i;j<nums1.length;j++) { int sum=0; int sum2=0; for(int
		 * k=i;k<=j;k++) { sum += nums1[k]; sum2 += nums2[k]; } if(sum == sum2 && j-i+1
		 * > ind) { ind=j-i+1; } }
		 * 
		 * }
		 */
    	
    	int ans=0;
    	int sum =0;
    	
    	Map<Integer,Integer> mp= new HashMap<Integer,Integer>();
    	mp.put(0, -1);
    	
    	for(int i=0;i<nums1.length;i++) {
    		sum += nums1[i] -nums2[i];
    		
    		if(mp.containsKey(sum)) {
    			ans = Math.max(ans, i-mp.get(sum));
    		}
    		else
    			mp.put(sum, i);
    	}
    	
    	

       return ans;
    }
    
    public static void main(String[] args) {
    	int[] nums1 = {1,1,0,1};//{0,1};
    	int[] nums2 = {0,1,1,0};//{1,1};
		System.out.println(widestPair(nums1,nums2));
	}
}

//https://leetcode.com/problems/fair-distribution-of-cookies/solutions/5261414/lemon-recursion-oh-easy-it-is/