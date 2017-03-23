package com.amazon.set_392;

import leetcode.sol.One_1_to_20.Two;
import leetcode.sol.helper.ListNode;

public class UpdateSecondHalf {

	public static void main(String[] args) {
		Two t = new Two();
		UpdateSecondHalf ush = new UpdateSecondHalf();
		ListNode l1 = t.init("23456");
		ush.flipValues(l1);
		//ush.doublePointer(l1);
		String word = "naimish";
		System.out.println(word.substring(0, 0));
	}

	private void doublePointer(ListNode root) {
		int length = 0;
		System.out.println(root);
		ListNode temp = root;
		ListNode doublePointer = root;
		ListNode dummyReverse = new ListNode(0);
		int index = 0;
		while (temp != null) {
			if(doublePointer != null || doublePointer.next != null){
				ListNode node = new ListNode(temp.val);
				ListNode sufix = dummyReverse.next;
				node.next = sufix;
				dummyReverse.next = node;
				index++;
				doublePointer = doublePointer.next.next;
			}
			if(doublePointer == null || doublePointer.next == null){
				ListNode node = dummyReverse.next;
				temp.val = node.val + temp.val;
				dummyReverse.next = dummyReverse.next.next;
			}
			temp = temp.next;
			
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
