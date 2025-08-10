package com.kas.practice_javadsa;
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }//plus one to right most not nine and for nine put zero
class LC369_PlusOne {
    public static ListNode plusOne(ListNode head) {
        // sentinel head
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode notNine = sentinel;

        // find the rightmost not-nine digit
        while (head != null) {
            if (head.val != 9) {
                notNine = head;
            }
            head = head.next;
        }

        // increase this rightmost not-nine digit by 1
        notNine.val++;
        notNine = notNine.next;

        // set all the following nines to zeros
        while (notNine != null) {
            notNine.val = 0;
            notNine = notNine.next;
        }

    return sentinel.val != 0 ? sentinel : sentinel.next;
  }
    public static void main(String[] args) {
		ListNode t2 = new ListNode(9,null);
    	ListNode t1 = new ListNode(2,t2);
    	ListNode head = new ListNode(1,t1);
		ListNode ans = plusOne(head);
		while(ans!=null) {
			System.out.println(ans.val);
			ans = ans.next;
		}
	}
}