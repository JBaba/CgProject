package com.facebook.set1;

/**
 * 
 *  Convert Ternary Expression to a Binary Tree
	Given a string that contains ternary expressions. The expressions may be nested, task is convert the given ternary 
	expression to a binary Tree.
	
	Examples:
	
	Input :  string expression =   a?b:c 
	Output :        a
	              /  \
	             b    c
	
	Input : expression =  a?b?c:d:e
	Output :     a
	           /  \
	          b    e
	        /  \
	       c    d
 * 
 * 
 * @author nviradia
 *
 */
public class TurnTernaryExpToBTree {

	public static void main(String[] args) {
		String t1 = "a?b:c";
		SNode root = turnTernaryToBTree(t1);
		System.out.println(root);
		
		t1 = "a?b?c:d:e";
		root = turnTernaryToBTree(t1);
		System.out.println(root);
		
		t1 = "a?b?c:d:e?f:g";
		root = turnTernaryToBTree(t1);
		System.out.println(root);
		
		t1 = "a?b?c:d?h:i:e?f:g";
		root = turnTernaryToBTree(t1);
		System.out.println(root);
		
	}

	private static SNode turnTernaryToBTree(String t1) {
		
		if(t1.length()==1)
			return new SNode(t1);
		
		String val = t1.charAt(0)+"";
		String left = "",right = "";
		
		if(t1.length()>5 && t1.substring(t1.length()-5).indexOf("?")!=-1){
			left = t1.substring(t1.length()-5);
			right = t1.substring(2, t1.length()-6);
		}else{
			left = t1.charAt(t1.length()-1)+"";
			right = t1.substring(2, t1.length()-2);
		}
		
		return new SNode(val, turnTernaryToBTree(left), turnTernaryToBTree(right));
	}

}

class SNode{
	String val;
	SNode left=null, right=null;
	
	public SNode(String val) {
		this.val = val;
	}
	
	public SNode(String val,SNode left,SNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	@Override
	public String toString() {
		return val+"->["+left+"]["+right+"]";
	}
}