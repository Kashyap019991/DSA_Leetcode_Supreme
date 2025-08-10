//https://leetcode.com/problems/sort-an-array/description/

//array passby value not refe https://www.edureka.co/community/6475/is-java-pass-by-reference-or-pass-by-value?show=6481#a6481
//but changes value in same  object 
package com.kas.dsasupreme._8_LinkedList;

import java.util.Arrays;

class _1_MiddleOfLL_LC_876 {

	// Definition for singly-linked list.
	static class ListNode {
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

	public static ListNode middleNode(ListNode head) {
		
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null) {
			
			fast = fast.next;
			if (fast != null) {
				slow = slow.next; // slow 1 step
				fast = fast.next; // fast 2 step
			}
			
		}
		return slow;

	}
	
	static void print(ListNode head){
		ListNode temp = head;
		while(temp != null){
			System.out.println(temp.val);
			temp = temp.next;
		}
		
	}
	public static void main(String[] args) {
		ListNode firs = new ListNode(1);
		ListNode sec = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		ListNode sixth = new ListNode(6);
		firs.next = sec;
		sec.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;

		ListNode head = (middleNode(firs));
		print(head);
	}
}