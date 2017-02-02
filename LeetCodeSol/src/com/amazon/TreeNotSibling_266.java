package com.amazon;

import leetcode.sol.tree.BinaryTree;

public class TreeNotSibling_266 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		bt.add(10);
		bt.add(5);
		bt.add(15);
		bt.add(3);
		bt.add(6);
		bt.add(12);
		bt.add(17);
		BTreePrinter.printBinaryTree(bt.root,0);
		
		TreeNotSibling_266 ts = new TreeNotSibling_266();
		ts.findNodeWhoDoesntSiblings(bt.root,6);
		ts.findNodeWhoDoesntSiblings(bt.root,10);
		ts.findNodeWhoDoesntSiblings(bt.root,17);
		ts.findNodeWhoDoesntSiblings(bt.root,15);
		ts.findNodeWhoDoesntSiblings(bt.root,53);

	}

	private void findNodeWhoDoesntSiblings(Node<Integer> root, int i) {

		if(root == null)
			return;
		
		int heightR = findMaxHeight(root.right);
		int heightL = findMaxHeight(root.left);
		
		System.out.println("R:"+heightR);
		System.out.println("L:"+heightL);
		
	}

	private int findMaxHeight(Node root) {

		if(root == null)
			return -1;
		
		int heightR = findMaxHeight(root.right);
		int heightL = findMaxHeight(root.left);
		
		return Math.max(heightR, heightL)+1;
	}

}
