package com.kas.practice_javadsa;

import java.util.HashMap;
import java.util.Map;

class SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int num:nums){
            if(map.get(num) == null){
                map.put(num,1);
            }
            else{
               int count= map.get(num)+1;
               map.put(num,count);
            }
        }

        for(int n:map.keySet()){
            if(map.get(n) ==1)
                return n;

            
        }
        return -1;
    }
    
    public static void main(String[] args) {
		SingleNumber sl = new SingleNumber();
		int[] nums = new int[]{4,1,2,1,2};
		System.out.println(sl.singleNumber(nums));
		
	}
}