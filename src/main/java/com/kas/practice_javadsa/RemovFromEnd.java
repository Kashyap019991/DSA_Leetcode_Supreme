package com.kas.practice_javadsa;
/**
 * Definition for singly-linked list.
 
  */
  class ListNodee {
      int val;
      ListNodee next;
      ListNodee() {}
      ListNodee(int val) { this.val = val; }
      ListNodee(int val, ListNodee next) { this.val = val; this.next = next; }
  }
 
class RemovFromEnd {
    public ListNodee removeNthFromEnd(ListNodee head, int n) {
        ListNodee curr = head;
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

    public int findLength(ListNodee head){
        int count=0;
        if(head == null) return count;
        ListNodee curr = head;
        while(curr != null){
            count++;
            curr = curr.next;
        }

        return count;
    }
}