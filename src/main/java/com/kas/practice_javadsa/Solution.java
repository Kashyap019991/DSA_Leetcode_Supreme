package com.kas.practice_javadsa;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num:nums){
        	if(num%2 ==0) {
            int count = map.getOrDefault(num,0)+1;
            map.put(num,count);
        	}
        }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                        if(value > nums.length/2){
                            return key;
                        }
            }
            return -1;
        }
    public static void main(String[] args) {
		Solution sl = new Solution();
		int[] m = {3,2,3,2,4,4,4};
		System.out.println(sl.majorityElement(m));
	}
    }
