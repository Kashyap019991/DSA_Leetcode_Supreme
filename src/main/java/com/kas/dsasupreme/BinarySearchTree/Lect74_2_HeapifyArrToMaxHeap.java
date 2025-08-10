package com.kas.dsasupreme.BinarySearchTree;

import java.util.Arrays;
public class Lect74_2_HeapifyArrToMaxHeap {
	static int[] arr = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
	//{54,53,55,52,50};
	static int N = arr.length;
	static void swap(int index, int lr){
		int k = arr[lr];
		arr[lr] = arr[index];
		arr[index] = k;
	}
	
	static void heapifyRec(int i){
		 
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if (l < N && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < N && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapifyRec(largest);
        }
	}
	static void heapifyItr(int i){
		int largest = i;
        while (i < N) {
        	 // Initialize largest as root
            int l = 2 * i + 1; // left = 2*i + 1
            int r = 2 * i + 2; // right = 2*i + 2
     
            // If left child is larger than root
            if (l < N && arr[l] > arr[largest])
                largest = l;
     
            // If right child is larger than largest so far
            if (r < N && arr[r] > arr[largest])
                largest = r;
     
            // If largest is not root
            if (largest != i) {
                int swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = swap;
                i = largest;
            }
            else
            	return;
            
                // Recursively heapify the affected sub-tree
                //heapifyRec(largest);
			
			/*if (left < N && right < N && arr[left] > arr[right] && arr[index] < arr[left]) {
				swap(index, left);
				index = left;
			}
			else if (left < N && right < N && arr[left] < arr[right] && arr[index] < arr[right]) 
			{
				swap(index, right);
				index = right;
				
			}
			else 
				return;
*/
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
		//[17, 15, 13, 9, 6, 5, 10, 4, 8, 3, 1]
		System.out.println(Arrays.toString(arr));
		
	}
}