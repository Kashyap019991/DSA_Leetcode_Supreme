package com.kas.practice_javadsa;

import java.util.HashMap;
import java.util.Map;
//lc 3351
class SumGoodSubSeq {
    public int sumOfGoodSubsequences(int[] nums) {
        int mod = 1000000007, n = nums.length;
        Map<Integer,Long> sumMap = new HashMap<>();
        Map<Integer,Long> countMap = new HashMap<>();
        for(int num : nums){
            long plusSum = sumMap.getOrDefault(num+1,0L);
            long minusSum = sumMap.getOrDefault(num-1,0L);
            long plusCount = countMap.getOrDefault(num+1,0L);
            long minusCount = countMap.getOrDefault(num-1,0L);
            
            sumMap.put(num,(sumMap.getOrDefault(num,0L)+(plusSum+num*plusCount)%mod)%mod);
            sumMap.put(num,(sumMap.getOrDefault(num,0L)+(minusSum+num*minusCount)%mod)%mod);
            sumMap.put(num,sumMap.getOrDefault(num,0L)+num);

            countMap.put(num,(countMap.getOrDefault(num,0L)+plusCount+minusCount+1)%mod);
        }
        long res = 0L;
        for(long sum : sumMap.values()){
            res = (res + sum)%mod;
        }
        return (int)res;
    }
    public static void main(String[] args) {
		int[] nums = {3,4,5};
		SumGoodSubSeq sl3 = new SumGoodSubSeq();
		System.out.println(sl3.sumOfGoodSubsequences(nums));
	}
}