package leetcode.sol.One_1_to_20;

import leetcode.sol.helper.ListNode;

/**
 * 
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
   Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
   Output: 7 -> 0 -> 8
 * 
 * @author jbaba
 *
 */
public class Two {
	

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	
    	if(l1 == null || l2 == null){
    		throw new IllegalArgumentException();
    	}
    	
    	ListNode result = null;
    	ListNode newItem = null;
    	ListNode next = null;
    	
    	int sum = 0;
    	
    	while (l1 != null || l2 != null) {
    		
    		if(l1==null && l2 != null)
    			sum = sum + l2.val;
    		else if(l2==null && l1 != null)
    			sum = sum + l1.val;
    		else
    			sum = sum + l1.val + l2.val;
    		
    		
    		if(result==null){
    			
    			if(sum>9){
    				result = new ListNode(Integer.parseInt((sum+"").charAt(1)+""));
    				sum =  Integer.parseInt((sum+"").charAt(0)+"");
    				result.next = new ListNode(sum);
    			}
    			else{
    				result = new ListNode(sum);
    				sum = 0;
    			}
    			
        		next = result;
        	}else{
        		
        		if(sum>9){
        			newItem = new ListNode(Integer.parseInt((sum+"").charAt(1)+""));
    				sum =  Integer.parseInt((sum+"").charAt(0)+"");
    				newItem.next = new ListNode(sum);
    			}
    			else{
    				newItem = new ListNode(sum);
    				sum = 0;
    			}
        		next.next = newItem;
        		next = newItem;
        	}
    		
    		if(l1 != null)
    			l1 = l1.next;
    		if(l2 != null)
    			l2 = l2.next;
		}
		        
    	return result;
    }
    
    public ListNode addTwoNumbersLeet(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    
    public ListNode init(String num){
    	ListNode result = null;
    	ListNode newItem = null;
    	ListNode next = null;
        for (int i = 0; i < num.length(); i++) {
        	if(result==null){
        		result = new ListNode(Integer.parseInt(num.charAt(i)+""));
        		next = result;
        	}else{
        		newItem = new ListNode(Integer.parseInt(num.charAt(i)+""));
        		next.next = newItem;
        		next = newItem;
        	}
		}
    	return result;
    }

	public static void main(String[] args) {
		Two t = new Two();
		ListNode l1 = t.init("2545");
		ListNode l2 = t.init("1");
		System.out.println(l1);
		System.out.println(l2);
		ListNode l3 = t.addTwoNumbers(l1, l2);
		System.out.println(l3);
	}

}


/*class ListNode {
    int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}

}*/
