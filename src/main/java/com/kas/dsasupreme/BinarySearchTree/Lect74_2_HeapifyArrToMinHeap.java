package com.kas.dsasupreme.BinarySearchTree;

import java.util.Arrays;
public class Lect74_2_HeapifyArrToMinHeap {
	static int[] arr = {3,1,6,5,9,8};
	//{54,53,55,52,50};
	static int N = arr.length;
	static void swap(int index, int lr){
		int k = arr[lr];
		arr[lr] = arr[index];
		arr[index] = k;
	}
	
	static void heapifyRec(int i){
		 
        int smallest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if (l < N && arr[l] < arr[smallest])
            smallest = l;
 
        // If right child is larger than largest so far
        if (r < N && arr[r] < arr[smallest])
            smallest = r;
 
        // If largest is not root
        if (smallest != i) {
            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapifyRec(smallest);
        }
	}
	static void heapifyItr(int index){
	
        while (index < N) {
			int left = (2 * index)+1;
			int right = (2 * index) + 2;

			
			if (left < N && right < N && arr[left] < arr[right] && arr[index] > arr[left]) {
				swap(index, left);
				index = left;
			}
			else if (left < N && right < N && arr[left] < arr[right] && arr[index] > arr[right]) 
			{
				swap(index, right);
				index = right;
				
			}
			else 
				return;

        }
	}
	public static void main(String[] args) {

		int startIdx = (N / 2) - 1;
		 
        // Perform reverse level order traversal
        // from last non-leaf node and heapify
        // each node
        for (int i = startIdx; i >= 0; i--) {
            heapifyItr(i);
        }
		
		System.out.println(Arrays.toString(arr));
		//[1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17]
	}
}