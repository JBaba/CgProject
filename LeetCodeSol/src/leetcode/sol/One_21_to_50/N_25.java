package leetcode.sol.One_21_to_50;

import leetcode.sol.One_1_to_20.Two;
import leetcode.sol.helper.ListNode;

/**
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

	If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
	
	You may not alter the values in the nodes, only nodes itself may be changed.
	
	Only constant memory is allowed.
	
	For example,
	Given this linked list: 1->2->3->4->5
	
	For k = 2, you should return: 2->1->4->3->5
	
	For k = 3, you should return: 3->2->1->4->5
 * 
 *  Questions link : https://leetcode.com/problems/reverse-nodes-in-k-group/
 * 
 * @author jbaba
 *
 */
public class N_25 {

	public N_25() {
	}
	
	/**
	 * First Impl
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode reverse = new ListNode(0);
		ListNode reverseLast = null; 
		int index = 0;
		ListNode temp = null;
		temp = head;
		
		while(temp != null && index != k){
			ListNode item = new ListNode(temp.val);
			
			if(reverse.next == null){
				reverse.next = item;
				reverseLast = item;
			}else{
				ListNode next = reverse.next;
				reverse.next = item;
				item.next = next;
			}
			
			index++;
			temp = temp.next;
			reverseLast.next = temp;
		}	
		
		if(index == k)
			return reverse.next;
		else
			return head;
    }
	
	public ListNode oddEvenList(ListNode head) {
	    if(head == null) 
	        return head;
	 
	    ListNode result = head;
	    ListNode p1 = head;
	    ListNode p2 = head.next;
	    ListNode connectNode = head.next;
	 
	    while(p1 != null && p2 != null){
	            ListNode t = p2.next;
	            if(t == null)
	                break;
	 
	            p1.next = p2.next;
	            p1 = p1.next;
	 
	            p2.next = p1.next;
	            p2 = p2.next;
	    }
	 
	    p1.next = connectNode;
	 
	    return result;
	}
	
	public static void main(String[] args) {
		Two t = new Two();
		ListNode l1 = t.init("112456");
		System.out.println(l1);
		
		ListNode l2 = t.init("35678");
		System.out.println(l2);
		
		N_25 n = new N_25();
		
		System.out.println("-----------------");
		
		System.out.println(n.reverseKGroup(l1, 3));
		System.out.println(n.reverseKGroup(l1, 1));
		System.out.println(n.reverseKGroup(l1, 7));
		
		ListNode l3 = t.init("123456789");
		l3 = n.oddEvenList(l3);
		System.out.println(l3);
	}

}
