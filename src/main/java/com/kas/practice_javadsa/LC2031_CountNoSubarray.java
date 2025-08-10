package com.kas.practice_javadsa;
class LC2031_CountNoSubarray {
    public static int subarraysWithMoreZerosThanOnes(int[] nums) {
        int n = nums.length, score = 0, m = (int)1e9 + 7, ans = 0;
        int max = 0, min = 0;
        for (int i = 0; i < n; i++){ // FIND THE BOUNDS FOR BINARY INDEX TREE FIRST
            score += (nums[i] == 0? -1 : 1);
            max = Math.max(max, score);
            min = Math.min(min, score);
        }

        int[] data = new int[max - min + 1];
        score = -min; // START POINT IS MINUS MIN
        update(score, 1, data); // WE'VE SEEN START POINT ONCE

        for (int i = 0; i < n; i++){ // QUERY
            score += (nums[i] == 0? -1 : 1);
            ans = (ans + sumRange(0, score - 1, data)) % m;
            update(score, 1, data);
        }

        return ans;
    }

    public static void update(int index, int add, int[] data) {
        index++;
        while(index < data.length){
            data[index] += add;
            index += index & -index;
        }
    }

    public static int sumRange(int left, int right, int[] data) {
        return getSum(right, data) - getSum(--left, data);
    }

    private static int getSum(int index, int[] data){
        int ans = 0;
        ++index;
        while(index > 0){
            ans += data[index];
            index -= index & -index;
        }

        return ans;
    }
    
    public static void main(String[] args) {
    	int[] a = new int[] {0,1,1,0,1};
    	System.out.println(subarraysWithMoreZerosThanOnes(a));
	}
}