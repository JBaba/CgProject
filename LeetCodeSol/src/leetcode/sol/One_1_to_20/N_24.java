package leetcode.sol.One_1_to_20;

import leetcode.sol.helper.ListNode;

/**
 *  Description
 *  Given a linked list, swap every two adjacent nodes and return its head.

	For example,
	Given 1->2->3->4, you should return the list as 2->1->4->3.
	
	Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
	
	problem : https://leetcode.com/problems/swap-nodes-in-pairs/
	
	web sol : http://www.programcreek.com/2014/04/leetcode-swap-nodes-in-pairs-java/
 * @author jbaba
 *
 */

public class N_24 {
	
	 public ListNode swapPairs2(ListNode head) {
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
	 
	 public ListNode swapPairs(ListNode head) {
		    if(head == null || head.next == null)   
		        return head;
		 
		    ListNode h = new ListNode(0);
		    h.next = head;
		    ListNode p = h;
		 
		    while(p.next != null && p.next.next != null){
		        //use t1 to track first node
		        ListNode t1 = p;
		        p = p.next;
		        t1.next = p.next;
		 
		        //use t2 to track next node of the pair
		        ListNode t2 = p.next.next;
		        p.next.next = p;
		        p.next = t2;
		    }
		 
		    return h.next;
	}

	public static void main(String[] args) {
		
		Two t = new Two();
		ListNode l1 = t.init("124896");
		System.out.println(l1);
		
		N_24 n = new N_24();
		System.out.println(n.swapPairs(l1));

	}

}
