package com.kas.practice_javadsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class FindRelRanks {
    public String[] findRelativeRanks(int[] score) {
		/*
		 * int N = score.length; int[] scoreCopy = new int[N]; System.arraycopy(score,
		 * 0, scoreCopy, 0, N);
		 * 
		 * // Save the index of each athlete Map<Integer, Integer> scoreToIndex = new
		 * HashMap<>(); for (int i = 0; i < N; i++) { scoreToIndex.put(scoreCopy[i], i);
		 * }
		 * 
		 * // Sort scoreCopy in ascending order 
		 * Arrays.sort(scoreCopy);
		 * 
		 * // Assign ranks to athletes // Traverse scoreCopy in reverse 
		 * String[] rank = new String[N]; 
		 * 
		 * for (int i = 0; i < N; i++) { if (i == 0) {
		 * rank[scoreToIndex.get(scoreCopy[N - i - 1])] = "Gold Medal"; } else if (i ==
		 * 1) { rank[scoreToIndex.get(scoreCopy[N - i - 1])] = "Silver Medal"; } else if
		 * (i == 2) { rank[scoreToIndex.get(scoreCopy[N - i - 1])] = "Bronze Medal"; }
		 * else { rank[scoreToIndex.get(scoreCopy[N - i - 1])] = Integer.toString(i +
		 * 1); } }
		 * 
		 * return rank;
		 */
    	
    	
    	String[] rank = new String[score.length];
    	int N = score.length;
    	Map<Integer,Integer> scrToInd =new HashMap<Integer,Integer>();
    	int[] scoreCopy = new int[N];
    	
    	for(int i=0;i< score.length;i++) {
    		scoreCopy[i] = score[i];
    	}
    	
    	
    	//map score with Index of it
    	for(int i=0;i<N;i++) {
    		scrToInd.put(scoreCopy[i],i);
    	}
    	
    	Arrays.sort(scoreCopy);
    	for(int i=0;i<scoreCopy.length;i++) {
    		if(i==0)
    			rank[scrToInd.get(scoreCopy[N-i-1])] = "Gold Medal";
    		else if(i==1)
    			rank[scrToInd.get(scoreCopy[N-i-1])] = "Silver Medal";
    		else if(i==2)
    			rank[scrToInd.get(scoreCopy[N-i-1])] = "Bronze Medal";
    		else
    			rank[scrToInd.get(scoreCopy[N-i-1])] = Integer.toString(i+1);
    		
    	}
    	return rank;
   
    }
    public static void main(String[] args) {
    	int[] score =
    		//{5,4,3,2,1};
    		{10,3,8,9,4};
    	FindRelRanks fr = new FindRelRanks();
    	System.out.println(Arrays.toString(fr.findRelativeRanks(score)));
	}
}