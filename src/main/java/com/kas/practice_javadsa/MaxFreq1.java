package com.kas.practice_javadsa;

import java.util.Arrays;

class MaxFreq1 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        long curr = 0;
        
        for (int right = 0; right < nums.length; right++) {
            long target = nums[right];
            curr += target;
            
            if ((right - left + 1) * target - curr > k) {
                curr -= nums[left];
                left++;
            }
        }
        
        return nums.length - left;
    }
    
    public static void main(String[] args) {
		MaxFreq1 sl = new MaxFreq1();
		int[] nums = {1,2,4};
		int k=5;
		System.out.println(sl.maxFrequency(nums, 5));
	}
}