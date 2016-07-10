package leetcode.sol.One_1_to_20;

import leetcode.sol.helper.ListNode;

public class N_21 {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode pointer = dummyHead;
		
		ListNode l1Copy = l1;
		ListNode l2Copy = l2;
		
		while(l1Copy!=null &&  l2Copy!=null){
			int val1 = l1Copy.val;
			int val2 = l2Copy.val;
			
			if(val1>val2){
				pointer.next = new ListNode(val2);
				pointer = pointer.next;
				l2Copy=l2Copy.next;
			}else{
				pointer.next = new ListNode(val1);
				pointer = pointer.next;
				l1Copy=l1Copy.next;
			}
		}
		
		if(l1Copy==null){
			pointer.next = l2Copy;
		}
		
		if(l2Copy==null){
			pointer.next = l1Copy;
		}
		
		return dummyHead.next;
    }

	public static void main(String[] args) {
		Two t = new Two();
		ListNode l1 = t.init("1124");
		System.out.println(l1);
		
		ListNode l2 = t.init("356");
		System.out.println(l2);
		
		N_21 n = new N_21();
		
		System.out.println(n.mergeTwoLists(l1, l2));
	}

}
