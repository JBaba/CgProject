package com.amazon;

public class Node<T> {
	
	public Node<T> right,left,parent;
	public T val;
	
	public Node(T val) {
		this.right=null;
		this.left=null;
		this.parent=null;
		this.val=val;
	}
	
	public Node(Node parent,int T) {
		this.right=null;
		this.left=null;
		this.parent=parent;
		this.val=val;
	}
	
	public Node(Node right,Node left,Node parent,int T) {
		this.right=right;
		this.left=left;
		this.parent=parent;
		this.val=val;
	}
	
	public Node(T i, Node<T> left, Node<T> right) {
		this.val = i;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		
		String s = "";
		
		if(left!=null && right != null)
			s = "->L["+left+"],R["+right+"]";
		else if(left!=null)
			s = "->L["+left+"]";
		else if(right!=null)	
			s = "->R["+right+"]";
		return val+s;
	}
}


