package com.kas.practice_javadsa;
class LC2031_CountNoSubarray2 {
    public static int subarraysWithMoreZerosThanOnes(int[] nums) {
        
    	int score =0;int maxim= Integer.MIN_VALUE;int minim = Integer.MAX_VALUE;
    	//adding -1 for 0 and +1 for 1 in score 
    	for(int i=0;i<nums.length;i++) {
    		score += nums[i] ==0 ? -1 : 1;
    		maxim = Math.max(score, maxim);
    		minim = Math.min(score, minim);
    	}
    	
        return 0;
     }
    
    public static void main(String[] args) {
    	int[] a = new int[] {0,1,1,0,1};
    	System.out.println(subarraysWithMoreZerosThanOnes(a));
	}
}