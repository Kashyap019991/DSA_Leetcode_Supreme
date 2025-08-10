package com.kas.practice_javadsa;
class MaxFreq {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, sum = 0, size = 2 * k, cur = sum, res = 0;

        for(int num: nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int[] count = new int[max + 1];

        for(int num: nums) count[num]++;

        if(k == 0){
            for(int num: count) res = Math.max(res, num);
            return res;
        }

        for(int i = 0; i <= Math.min(max, min + k); i++){
            sum += count[i];
            if(i > size) sum -= count[i - size];
        }

        for(int i = min; i <= max; i++){
            if(i > k) sum -= count[i - k - 1];
            if(i > min && i + k <= max) sum += count[i + k];
            cur = sum - count[i];
            res = Math.max(res, count[i] + Math.min(cur, numOperations));
        }

        return res;
    }
    
    
    public static void main(String[] args) {
    	int[] nums = {1,4,5};int k = 1, numOperations = 2;
    	MaxFreq sl1 = new MaxFreq();
    	System.out.println(sl1.maxFrequency(nums, k, numOperations));
	}
}