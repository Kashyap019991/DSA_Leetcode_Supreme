package com.kas.dsasupreme.BinarySearchTree;

import java.util.PriorityQueue;

public class Lect75_1_2_KthLargestHeap {
	static Integer[] arr = {7 ,10,4,20,15}; 
			//{ 3, 1, 6, 5, 9, 8 };
	// {54,53,55,52,50};

	static int kthSmalMaxHeap(int k) {
		int ans = 0;
		//Min Heap
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		
		// push 0 to k-1 elem to queue
		for (int i = 0; i < k; i++)
			pq.add(arr[i]);
		
		// k to size-1 elem
		for (int j = k; j < arr.length; j++) {
			if (arr[j] > pq.peek()) {
				pq.poll();
				pq.add(arr[j]);
			}
		}
		//top elem ans
		ans = pq.peek();
		return ans;
	}

	public static void main(String[] args) {
		int k = 4;
		int ans = kthSmalMaxHeap(k);
		System.out.println(ans);
		// [1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17]
		
		
	}
}