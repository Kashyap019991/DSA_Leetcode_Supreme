package com.kas.dsasupreme.BinarySearchTree;

import java.util.PriorityQueue;

import com.kas.Tree.TreeDay1;
import com.kas.Tree.TreeNode;




public class Lect76_1_KthlargestSubarraySum {
	
	static int kthLargestSum(int[] arr, int k){
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0 ; i< arr.length;i++){
			int sum = 0;
			for(int j = i; j<arr.length;j++){
				sum  = sum + arr[j];	
				if(pq.size() < k)
				{
					pq.add(sum);
				}
				else{
					if(pq.peek() < sum){
						pq.poll();
						pq.add(sum);
					}
				}
			}
			
		}
		return pq.peek();
	}
	public static void main(String[] args) {
		int arr[] = { -2,1,-3,4,-1,2,1,-5,4};
        //int size = len.length;
		int k = 1;
        System.out.println(
            "Kth largest sum Subarray "
            + kthLargestSum(arr,k));
	        
	}

}