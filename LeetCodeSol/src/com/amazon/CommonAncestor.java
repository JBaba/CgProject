package com.amazon;

import leetcode.sol.tree.BinaryTree;

public class CommonAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		bt.add(70);
		bt.add(60);
		bt.add(65);
		bt.add(50);
		bt.add(67);
		bt.add(64);
		bt.add(63);
		bt.add(62);
		bt.add(90);
		
		BTreePrinter.printBinaryTree(bt.root,0);
		
		Status st = findAncestor(bt.root,63,150);
		System.out.println(st);

	}

	private static Status findAncestor(Node<Integer> root,int n1,int n2) {
		if(root==null || root.val == null)
			return new Status(0, null);
		
		Status leftStatus = findAncestor(root.left,n1,n2);
		
		if(leftStatus.numOfNodes == 2)
			return leftStatus;
		
		Status rightStatus = findAncestor(root.right,n1,n2);
		
		if(rightStatus.numOfNodes == 2)
			return rightStatus;
		
		Status res = new Status(leftStatus.numOfNodes+rightStatus.numOfNodes
				+((root.val == n1)?1:0)+((root.val == n2)?1:0), root);
		return res;
	}

}

class Status {
	public int numOfNodes;
	public Node<Integer> treeNode;
	
	public Status(int num,Node<Integer> node) {
		numOfNodes = num;
		treeNode = node;
	}
	
	@Override
	public String toString() {
		return "Num:"+numOfNodes+" Node:"+treeNode.val;
	}
}
