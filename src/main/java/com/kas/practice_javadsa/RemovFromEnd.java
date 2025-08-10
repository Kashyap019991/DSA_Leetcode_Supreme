package com.kas.practice_javadsa;
/**
 * Definition for singly-linked list.
 
  */
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class RemovFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int length = findLength(head);
        int travs = length-n-1;
        int i=0;
        if(travs == -1) return head.next;
        while(i < travs){

            curr =curr.next;
            i++;
        }
        curr.next = curr.next.next;
        return head;
    }

    public int findLength(ListNode head){
        int count=0;
        if(head == null) return count;
        ListNode curr = head;
        while(curr != null){
            count++;
            curr = curr.next;
        }

        return count;
    }
}