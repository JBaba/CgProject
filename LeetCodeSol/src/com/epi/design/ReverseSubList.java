package com.epi.design;

import leetcode.sol.One_1_to_20.Two;
import leetcode.sol.helper.ListNode;

public class ReverseSubList {

	public static void main(String[] args) {
		Two t = new Two();
		ListNode l1 = t.init("123456789");
		System.out.println(l1);
		ListNode l2 = reverse(l1,3,6);
		System.out.println(l2);
	}

	private static ListNode reverse(ListNode l1, int start, int end) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = l1;
		ListNode sublistHead = dummyHead;
		int k = 1;
		
		while(k++ < start)
			sublistHead = sublistHead.next;
		
		ListNode sublistInter = sublistHead.next;
		
		while(start++<end){
			ListNode temp = sublistInter.next;
			sublistInter.next = temp.next;
			temp.next = sublistHead.next;
			sublistHead.next = temp;
		}
		
		return dummyHead.next;
	}

}
