package com.kas.practice_javadsa;

import java.util.Arrays;
import java.util.TreeMap;

class MaxSlidngWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int [] res = new int[nums.length-k+1];
        TreeMap<Integer,Integer> map = new TreeMap<>();
        if(nums.length == 0)return nums;
        for(int i=0;i<k;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        res[0] = map.lastKey();
        for(int i=k;i<nums.length;i++){
            if(nums[i-k] != nums[i]){
                if(map.get(nums[i-k])>1)map.put(nums[i-k],map.get(nums[i-k])-1);
                else map.remove(nums[i-k]);
                	map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
            res[i-k+1] = map.lastKey();
        }
        return res;
    }
    public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k=3;
		MaxSlidngWindow sl = new MaxSlidngWindow();
		System.out.println(Arrays.toString(sl.maxSlidingWindow(nums,k)));
	}
}