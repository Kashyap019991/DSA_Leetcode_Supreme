package com.kas.dsasupreme.BinarySearchTree;

import java.util.Arrays;

import com.kas.Tree.TreeDay1;
import com.kas.Tree.TreeNode;




public class Lect75_3_Merge2MaxHeap {
	
	static void heapifyItr(int i, int[] arr){
		int largest = i;
		int N = arr.length;
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

        }
	}
	public static void main(String[] args) {
		//12 10 9 2 5 7 6 
		  int[] a = { 10, 5, 6, 2 };
	        int[] b = { 12, 7, 9 };
	        int N = a.length;
	        int M = b.length;
	 
	        int[] merged = new int[M + N];
	        //a elem into new array
	        for(int i=0;i<N;i++)
	        	merged[i] = a[i];
	        //b elem into new array
	        for(int i = 0 ; i <M; i++)
	        	merged[N + i] = b[i];
	        
	        for(int i = merged.length /2 -1 ; i >=0;i--){
	        	heapifyItr(i, merged);
	        }
	        
	        System.out.println(Arrays.toString(merged));
	        
	}

}