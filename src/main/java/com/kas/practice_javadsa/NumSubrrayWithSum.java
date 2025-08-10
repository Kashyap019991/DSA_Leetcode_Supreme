package com.kas.practice_javadsa;

import java.util.HashMap;
import java.util.Map;

class NumSubrrayWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int totalCount = 0;
        int currentSum = 0;
        // {prefix: number of occurrence}
        Map<Integer, Integer> freq = new HashMap<>(); // To store the frequency of prefix sums

        for (int num : nums) {
            currentSum += num;
            if (currentSum == goal){
                totalCount++;
            }

            // Check if there is any prefix sum that can be subtracted from the current sum to get the desired goal
            if (freq.containsKey(currentSum - goal)){
                totalCount += freq.get(currentSum - goal);
            }

            freq.put(currentSum, freq.getOrDefault(currentSum, 0) + 1);
        }

        return totalCount;
    }
    public static void main(String[] args) {
		NumSubrrayWithSum sl = new NumSubrrayWithSum();
		int[] nums = {1,0,1,0,1}; int goal = 2;
		System.out.println(sl.numSubarraysWithSum(nums, goal));
	}
}