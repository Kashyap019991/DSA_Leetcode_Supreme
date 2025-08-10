package com.kas.dsasupreme.BinarySearchTree;

import java.util.Arrays;


import java.util.Comparator;
import java.util.PriorityQueue;

import com.kas.Tree.TreeDay1;
import com.kas.Tree.TreeNode;

class Node {
	int data;
	int row;
	int col;

	Node(int data, int row, int col) {
		this.data = data;
		this.row = row;
		this.col = col;
	}
}

public class Lect76_MergeKsortedArray {

	static void mergeKArrays(int[][] arr, int N, int[] op) {

		PriorityQueue<Node> pqMinHeap = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.data - o2.data; // min heap
			}
		});

		for (int i = 0; i < N; i++) {
			Node fNode = new Node(arr[i][0],i,0);
			pqMinHeap.add(fNode);
			
		}
		int i =0;
		while(pqMinHeap.size() >0)
		{
			Node mNode = pqMinHeap.poll();
			
			//add in heap elem of same row ans next col
			if(mNode.row <N && mNode.col < arr[0].length-1)
			pqMinHeap.add(new Node(arr[mNode.row][mNode.col+1],mNode.row,mNode.col+1));
			
			//add in ans array
			op[i] = mNode.data;
			
			i++;
			
		}
		return;
	}

	public static void main(String[] args) {
		int[][] arr = { { 2, 6, 12, 34 }, { 1, 9, 20, 1000 }, { 23, 34, 90, 2000 } };
		int K = 4;
		int N = 3;
		int[] output = new int[N * K];

		// Function call
		mergeKArrays(arr, N, output);
		System.out.println(Arrays.toString(output));
	}

}