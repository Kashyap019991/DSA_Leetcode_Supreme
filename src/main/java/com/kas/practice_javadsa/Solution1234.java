package com.kas.practice_javadsa;

import java.util.PriorityQueue;

class Solution1234 {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> costMin = new PriorityQueue<Integer>();

        for(int i=0;i<costs.length;i++){
            costMin.add(costs[i]);
        }
        long totCost=0;
        while(k >0){
            k--;
            totCost += costMin.remove();
        }
        return totCost;
    }
    
    
    public static void main(String[] args) {
		int[] inp = {17,12,10,2,7,2,11,20,8};
		int k=3;
		int candidates =4;
		Solution1234 sl = new Solution1234();
		System.out.println(sl.totalCost(inp,k,candidates));
	}
}