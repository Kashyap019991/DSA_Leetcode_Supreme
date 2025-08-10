package com.kas.practice_javadsa;
class BeautySum {//1781
	 public int getMaxCnt(int[] freq) {
	        int maxCount = 0;
	        for (int i = 0; i <26; i++) {
	            maxCount = Math.max(maxCount, freq[i]);
	        }
	        return maxCount;
	    }

	 public int getMinCnt(int[] freq) {
	        int minCount = Integer.MAX_VALUE;
	        for (int i = 0; i <26; i++) {
	            if (freq[i] != 0) {
	                minCount = Math.min(minCount, freq[i]);
	            }
	        }
	        return minCount;
	    }
     public int beautySum(String s) {
         int sum = 0;
         for (int i = 0; i < s.length(); i++) {
             int[] freq = new int[26]; //0
             for (int j = i; j < s.length(); j++) {
                 freq[s.charAt(j) - 'a']++;
                 int beauty = getMaxCnt(freq) - getMinCnt(freq);
                 sum += beauty;
             }
         }
         return sum;
     }
    
    public static void main(String[] args) {
		String s="aabcb";
		BeautySum sl = new BeautySum();
		System.out.println(sl.beautySum(s));
	}
}