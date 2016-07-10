package leetcode.sol.One_1_to_20;

import leetcode.sol.helper.ListNode;

/**
 *  Given a linked list, swap every two adjacent nodes and return its head.

	For example,
	Given 1->2->3->4, you should return the list as 2->1->4->3.
	
	Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * @author jbaba
 *
 */

public class N_24 {
	
	 public ListNode swapPairs(ListNode head) {
		 ListNode dummy = new ListNode(0);
		 dummy.next = head;
		 ListNode pointer = dummy.next;
		 
		 int index = 1;
		 while(pointer != null){
			 
			 if(index == 1 || index == 3){
				 if(pointer.next != null){
					 ListNode first = new ListNode(pointer.val);
					 first.next = pointer.next.next;
					 
					 pointer.val = pointer.next.val;
					 pointer.next = first;
				 }
				 
				 index = 1;
			 }
			 
			 pointer = pointer.next;
			 index ++;
			 
		 }
		 
		 
		 return dummy.next;
	 }

	public static void main(String[] args) {
		
		Two t = new Two();
		ListNode l1 = t.init("124896");
		System.out.println(l1);
		
		N_24 n = new N_24();
		System.out.println(n.swapPairs(l1));

	}

}
