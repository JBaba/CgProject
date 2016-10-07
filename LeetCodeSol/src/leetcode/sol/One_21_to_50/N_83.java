package leetcode.sol.One_21_to_50;

import leetcode.sol.One_1_to_20.Two;
import leetcode.sol.helper.ListNode;

/**
 * 
 *Given a sorted linked list, delete all duplicates such that each element appear only once.

	For example,
	Given 1->1->2, return 1->2.
	Given 1->1->2->3->3, return 1->2->3.
 * 
 *  Questions link : https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * 
 * @author jbaba
 *
 */
public class N_83 {

	public N_83() {
	}
	
	/**
	 * First Impl
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode deleteDuplicates(ListNode head) {
		ListNode rotate = new ListNode(0);
		ListNode next = rotate;
		ListNode temp = head;
		Integer prevValue = null;
		
		while (temp != null) {
			Integer val = temp.val;
			if(prevValue == null || prevValue.intValue() != val.intValue()){
				ListNode node = new ListNode(temp.val);
				next.next = node;
				next = next.next;
				prevValue = temp.val;
			}
			
			temp = temp.next;
		}
		
		return rotate.next;
    }
	
	public static void main(String[] args) {
		Two t = new Two();
		ListNode l1 = t.init("115667");
		System.out.println(l1);
		
		ListNode l2 = t.init("11222");
		System.out.println(l2);
		
		N_83 n = new N_83();
		
		System.out.println("-----------------");
		System.out.println(n.deleteDuplicates(l1));
		System.out.println(n.deleteDuplicates(l2));
	}

}
