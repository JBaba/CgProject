package leetcode.sol.One_1_to_20;


import leetcode.sol.helper.ListNode;


/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 
 * @author jbaba
 *
 */
public class N_23 {
	
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode dummyHead = new ListNode(0);
		ListNode pointer = dummyHead;
		
		
		return dummyHead.next;
	}

	public static void main(String[] args) {
		Two t = new Two();
		ListNode l1 = t.init("1148");
		System.out.println(l1);
		
		ListNode l2 = t.init("369");
		System.out.println(l2);
		
		ListNode l3 = t.init("259");
		System.out.println(l3);
		
		ListNode[] lists = new ListNode[3];
		lists[0] = l1;
		lists[1] = l2;
		lists[2] = l3;
		
		N_23 n = new N_23();
		
		System.out.println(n.mergeKLists(lists));
	}

}
