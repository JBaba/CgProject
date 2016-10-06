package leetcode.sol.One_21_to_50;

import leetcode.sol.One_1_to_20.Two;
import leetcode.sol.helper.ListNode;

/**
 * 
 *Given a list, rotate the list to the right by k places, where k is non-negative.

	For example:
	Given 1->2->3->4->5->NULL and k = 2,
	return 4->5->1->2->3->NULL.
 * 
 *  Questions link : https://leetcode.com/problems/rotate-list/
 * 
 * @author jbaba
 *
 */
public class N_61 {

	public N_61() {
	}
	
	/**
	 * First Impl
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode rotateRight(ListNode head, int k) {
		ListNode rotate = new ListNode(0);
		ListNode firstItem = head;
		ListNode secondPointer = head;
		ListNode firstPointer = head;
		int index = 0;
		
		
		while (firstPointer!=null && firstPointer.next != null ) {
			if(index == k){
				secondPointer = secondPointer.next;
			}

			firstPointer = firstPointer.next;
			
			if(index != k)
				index++;
		}
		
		if(index != k || k==0){
			rotate.next = head;
		}else{
			rotate.next = secondPointer.next;
			firstPointer.next = firstItem;
			secondPointer.next = null;
		}
		return rotate.next;
    }
	
	public static void main(String[] args) {
		Two t = new Two();
		ListNode l1 = t.init("1234567");
		System.out.println(l1);
		
		ListNode l2 = t.init("35678");
		System.out.println(l2);
		
		N_61 n = new N_61();
		
		System.out.println("-----------------");
		
		/*System.out.println(n.rotateRight(l1, 1));
		
		l1 = t.init("1234567");
		System.out.println(n.rotateRight(l1, 2));
		
		l1 = t.init("1234567");
		System.out.println(n.rotateRight(l1, 3));
		
		l1 = t.init("1234567");
		System.out.println(n.rotateRight(l1, 4));
		
		l1 = t.init("1234567");
		System.out.println(n.rotateRight(l1, 5));
		
		l1 = t.init("1234567");
		System.out.println(n.rotateRight(l1, 6));*/
		
		l1 = t.init("1234567");
		System.out.println(n.rotateRight(l1, 7));
	}

}
