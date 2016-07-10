package leetcode.sol.One_1_to_20;

import leetcode.sol.helper.ListNode;

public class N_21 {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		return l2;
    }

	public static void main(String[] args) {
		Two t = new Two();
		ListNode l1 = t.init("124");
		System.out.println(l1);
		
		ListNode l2 = t.init("356");
		System.out.println(l2);
		
		N_21 n = new N_21();
		
		System.out.println(n.mergeTwoLists(l1, l2));
	}

}
