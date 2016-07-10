package leetcode.sol.One_1_to_20;


import java.util.Comparator;
import java.util.PriorityQueue;

import leetcode.sol.helper.ListNode;


/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 
 * @author jbaba
 *
 */
public class N_23 {
	
	/**
	 * This is time limit exceeded solution
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists2(ListNode[] lists) {
		ListNode dummyHead = new ListNode(0);
		ListNode pointer = dummyHead;
		
		ListNode[] copyList = new ListNode[lists.length];
		int index = 0;
		for(ListNode node:lists){
			copyList[index] = node;
			index++;
		}
		
		while(!isEmpty(copyList)){
			int val = getVal(copyList);
			pointer.next = new ListNode(val);
			pointer = pointer.next;
		}
		
		return dummyHead.next;
	}

	private int getVal(ListNode[] lists) {
		int index = 0;
		int pointerIndex = 0;
		Integer first = null;
		Integer second = null;
		for(ListNode node:lists){
			if(first == null && node != null){
				first = node.val;
				index = pointerIndex;
			}else if(second == null && node != null){
				second = node.val;
			}else if(node != null){
				second = node.val;
			}
			
			if(second != null && first.compareTo(second) > 0){
				first = second;
				index = pointerIndex;
			}
		
			pointerIndex++;
		}
		
		lists[index] = lists[index].next; 
		
		return first.intValue();
	}

	private boolean isEmpty(ListNode[] lists) {
		for(ListNode node:lists){
			if(node != null)
				return false;
		}
		return true;
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode dummyHead = new ListNode(0);
		ListNode pointer = dummyHead;
		
		PriorityQueue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val-o2.val;
			}
		});
		
		for(ListNode list :lists){
			if(list!=null)
				q.add(list);
		}
		
		while (!q.isEmpty()) {
			ListNode node = q.poll();
			pointer.next = node;
			pointer = pointer.next;
			
			if(node.next != null)
				q.add(node.next);
		}
		
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
