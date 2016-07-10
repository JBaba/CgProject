package leetcode.sol.One_1_to_20;

import leetcode.sol.helper.ListNode;

/**
 *  https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 *  Given a linked list, remove the nth node from the end of list and return its head.
	
	For example,
	
	   Given linked list: 1->2->3->4->5, and n = 2.
	
	   After removing the second node from the end, the linked list becomes 1->2->3->5.
	Note:
	Given n will always be valid.
	Try to do this in one pass.
 * 
 * 
 * @author jbaba
 *
 */


public class Nineteen {

	/**
	 * Two Pass Solution
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		
		ListNode tempHead = new ListNode(0);
		tempHead.next = head;
		
		ListNode pointer = tempHead;
		int size = 1;
		
		while(pointer.next != null){
			pointer = pointer.next;
			size ++;
		}
		
		System.out.println("size:"+size);
		pointer = tempHead;
		int index = 0;
		while(index != (size-n-1)){
			pointer = pointer.next;
			index++;
		}
		
		ListNode temp = pointer.next;
		pointer.next = temp.next;
		
		return tempHead.next;
    }
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode tempHead = new ListNode(0);
		tempHead.next = head;
		ListNode firstPointer = tempHead;
		ListNode secondPointer = tempHead;
		
		int indexDiff= -1;
		
		while(firstPointer!=null){
			if(indexDiff==n)
				secondPointer=secondPointer.next;
			else
				indexDiff++;
			firstPointer=firstPointer.next;
		}
		secondPointer.next = secondPointer.next.next;
		
		return tempHead.next;
    }
	
	public static void main(String[] args) {
		Two t = new Two();
		ListNode l1 = t.init("12345");
		System.out.println(l1);
		
		Nineteen n = new Nineteen();
		l1 = n.removeNthFromEnd(l1, 1);
		System.out.println(l1);
	}

}

