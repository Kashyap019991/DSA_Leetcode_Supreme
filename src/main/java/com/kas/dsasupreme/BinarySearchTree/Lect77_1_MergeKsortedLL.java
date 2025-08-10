package com.kas.dsasupreme.BinarySearchTree;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.kas.Tree.TreeDay1;
import com.kas.Tree.TreeNode;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

}

public class Lect77_1_MergeKsortedLL {

	static ListNode mergeKArrays(ListNode[] lnArr) {
		if(lnArr.length != 0){
		PriorityQueue<ListNode> pqMinHeap = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return o1.val - o2.val; // min heap
			}
		});
		
		for (int i = 0; i < lnArr.length; i++) {
			if(lnArr[i] != null)
			pqMinHeap.add(lnArr[i]);
		}
		
		ListNode head = null,tail = null;
		while(pqMinHeap.peek() != null){
			if(head == null)
			{                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
				//1. assign top of minheap to head and tail and remove it from heap
				head = tail = pqMinHeap.poll();
				//2. add next element of head to top in minheap
				if(head.next != null)
				pqMinHeap.add(head.next);
			}
			else{
				//insert top of heap to end of ll
				tail.next = pqMinHeap.poll();
				
				//put tail cursor to lastly added element
				tail = tail.next;
				
				//add next element to heap of recently poped
				if(tail.next != null)
				pqMinHeap.add(tail.next);
			}
		}
		
		
		return head;
		}
		return new ListNode(0).next;
	}

	public static void main(String[] args) {
		
		//[[1,4,5],[1,3,4],[2,6]]
		ListNode[] lnArr = new ListNode[3];
		lnArr[0] = new ListNode(1,new ListNode(4, new ListNode(5,null)));
		lnArr[1] = new ListNode(1,new ListNode(3, new ListNode(4,null)));
		lnArr[2] = new ListNode(2,new ListNode(6, null));
		ListNode headAns = mergeKArrays(lnArr);
		
		while(headAns != null){
			
			System.out.println(headAns.val);
			headAns = headAns.next;
		}
	}

}