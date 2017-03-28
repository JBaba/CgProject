package com.amazon.set_392;

import leetcode.sol.One_1_to_20.Two;
import leetcode.sol.helper.ListNode;

public class UpdateSecondHalf {

	public static void main(String[] args) {
		Two t = new Two();
		UpdateSecondHalf ush = new UpdateSecondHalf();
		ListNode l1 = t.init("234567");
		ush.doublePointer(l1);
		ListNode l2 = t.init("23456");
		ush.doublePointer(l2);
		String word = "naimish";
		System.out.println(word.substring(0, 0));
	}

	private void doublePointer(ListNode root) {
		ListNode p1 = root;
		ListNode p2 = root;
		ListNode dummyHeadReverse = new ListNode(0);
		while(p2 != null && p2.next != null){
			ListNode node = new ListNode(p1.val);
			ListNode sufix = dummyHeadReverse.next;
			node.next = sufix;
			dummyHeadReverse.next = node;
			
			p1 = p1.next;
			p2 = p2.next.next;
		}
		
		ListNode secondHalf = null;
		
		if(p2 == null){
			secondHalf = p1;
		}else if(p2.next == null){
			secondHalf = p1;
			ListNode node = new ListNode(p1.val);
			ListNode sufix = dummyHeadReverse.next;
			node.next = sufix;
			dummyHeadReverse.next = node;
		}
		
		while(secondHalf != null){
			ListNode node = dummyHeadReverse.next;
			dummyHeadReverse.next = node.next;
			secondHalf.val += node.val;
			secondHalf = secondHalf.next;
		}
		
		System.out.println(root);
	}

	private void flipValues(ListNode root) {
		int length = 0;
		System.out.println(root);
		ListNode temp = root;
		while(temp.next != null){
			temp = temp.next;
			length++;
		}
		
		int half = length/2;
		ListNode dummyReverse = new ListNode(0);
		int index = 0;
		temp = root;
		while (temp != null) {
			if(index <= half){
				ListNode node = new ListNode(temp.val);
				ListNode sufix = dummyReverse.next;
				node.next = sufix;
				dummyReverse.next = node;
				index++;
			}
			if(index > half){
				ListNode node = dummyReverse.next;
				temp.val = node.val + temp.val;
				dummyReverse.next = dummyReverse.next.next;
			}
			temp = temp.next;
		}
		System.out.println(root);
	}

}
