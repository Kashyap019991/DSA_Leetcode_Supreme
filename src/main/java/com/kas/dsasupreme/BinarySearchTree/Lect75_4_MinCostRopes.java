package com.kas.dsasupreme.BinarySearchTree;

import java.util.PriorityQueue;

import com.kas.Tree.TreeDay1;
import com.kas.Tree.TreeNode;




public class Lect75_4_MinCostRopes {
	
	static long minCost(long[] arr){
		
		//By def Min Heap
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		for(long i:arr)
			pq.add(i);
		long ans = 0;
		while(pq.size() > 1){
			long a = pq.poll();
			long b = pq.poll();
			
			long sum = a+ b;
			ans += sum;
			
			pq.add(sum);
		}
		
		return ans;
	}
	public static void main(String[] args) {
		long arr[] = { 4, 3, 2, 6 };
        //int size = len.length;
 
        System.out.println(
            "Total cost for connecting ropes is "
            + minCost(arr));
	        
	}

}