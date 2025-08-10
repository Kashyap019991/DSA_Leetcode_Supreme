package com.kas.practice_javadsa;
class MinAvgDiff {
    public int minimumAverageDifference(int[] nums) {
        int sum=0,l=0,r=0,lAvg=0,rAvg=0;
        int minAvgDiff=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
            sum += nums[i];

        for(int i=0;i<nums.length;i++){
            l += nums[i];
            lAvg = l/(i+1);
            r = sum - (l);
            if(i !=nums.length -1)
            	rAvg = r/(nums.length - i-1);
            else
            	rAvg = r / (nums.length -i);

            int currDiff = Math.abs(lAvg - rAvg);

            minAvgDiff = Math.min(minAvgDiff, currDiff);
        }
        return minAvgDiff;
    }
    public static void main(String[] args) {
		int[] nums = {2,5,3,9,5,3};
		int n=6;
		MinAvgDiff sl = new MinAvgDiff();
		System.out.println(sl.minimumAverageDifference(nums));
	}
}