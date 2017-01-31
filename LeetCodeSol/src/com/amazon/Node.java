package com.amazon;

public class Node<T> {
	
	public Node right,left,parent;
	public int val;
	
	public Node(int val) {
		this.right=null;
		this.left=null;
		this.parent=null;
		this.val=val;
	}
	
	public Node(Node parent,int val) {
		this.right=null;
		this.left=null;
		this.parent=parent;
		this.val=val;
	}
	
	public Node(Node right,Node left,Node parent,int val) {
		this.right=right;
		this.left=left;
		this.parent=parent;
		this.val=val;
	}
	
	@Override
	public String toString() {
		return val+"->L["+left.val+"],R["+right.val+"]";
	}
}


