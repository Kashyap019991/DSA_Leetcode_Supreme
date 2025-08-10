package com.kas.dsasupreme.dp;

import java.util.PriorityQueue;

public class Day140__6_MonCostRopes_gfg {
/*
 * int N = 7; // chokolate packet array each show no. of chockolate in pkt 
		int M = 3;//no. of students
		int[] A = new int[]{7, 3, 2, 4, 9, 12, 56};
 * 
 */
	static long minCost(long arr[], int n)  {
		PriorityQueue<Long> pq =new PriorityQueue<>();
		long cost =0;
		
		for(int i = 0;i<arr.length;i++){
			pq.add(arr[i]);
		}
		
		while(pq.size() > 1){
			long first = pq.poll();
			long sec = pq.poll();
			cost = cost + first + sec;
			pq.add(first + sec);
		}
		return cost;
	}

	public static void main(String[] args) {
		int n = 4;//2,3,4,6
		long[] A = new long[]{4, 3, 2, 6};
		System.out.println(minCost(A,n));
	}
}
