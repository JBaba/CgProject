package com.amazon;

import leetcode.sol.tree.BinaryTree;

public class MinLength_266 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		bt.add(100);
		bt.add(50);
		bt.add(150);
		bt.add(30);
		bt.add(60);
		bt.add(120);
		bt.add(170);
		bt.add(20);
		bt.add(10);
		BTreePrinter.printBinaryTree(bt.root,0);

		MinLength_266 ml = new MinLength_266();
		int len = ml.minLength(bt.root.left.left);
		System.out.println(len);
	}

	private int minLength(Node<Integer> node) {
		if(node==null)
			return -1;
		return Math.min(minLength(node.left), minLength(node.right))+1;
	}
	
}
