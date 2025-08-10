package com.kas.practice_javadsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class TopKFreqent {
    public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer,Integer> tem=new HashMap<>();
    for(int i:nums){
        tem.put(i,tem.getOrDefault(i,0)+1);
    }
    PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>(
        (a,b)->b.getValue()-a.getValue()
    );
    for(Map.Entry<Integer,Integer> e:tem.entrySet()){
        pq.offer(e);
    }
    int[] res=new int[k];
    for(int i=0;i<k;i++){
        res[i]=pq.poll().getKey();
    }
    return res;
    }
    
    public static void main(String[] args) {
    	int[] nums = {1,1,1,2,2,3}; 
    	int k=2;
    	
    	largestOddNumber sl = new largestOddNumber();
    	System.out.println(Arrays.toString(sl.topKFrequent(nums, k)));
	}
}
//347. Top K Frequent Elements