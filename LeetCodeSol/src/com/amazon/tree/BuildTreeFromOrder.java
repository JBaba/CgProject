package com.amazon.tree;

import leetcode.sol.tree.BinaryTree;

import com.amazon.BTreePrinter;
import com.amazon.Node;
import com.amazon.PrintTreeUsingRecursion;

public class BuildTreeFromOrder {

	public static void main(String[] args) {
		BuildTreeFromOrder t = new BuildTreeFromOrder();
		
		BinaryTree bt = new BinaryTree();
		bt.add(29);
		bt.add(15);
		bt.add(14);
		bt.add(26);
		bt.add(17);
		bt.add(8);
		bt.add(12);
		bt.add(50);
		bt.add(30);
		bt.add(60);
		bt.add(25);
		bt.add(55);
		bt.add(65);
		bt.add(70);
		BTreePrinter.printBinaryTree(bt.root,0);
		
		// 29,15,14,8,12,26,17,25,50,30,60,55,65,70,
		
		PrintTreeUsingRecursion.printPreOrder(bt.root);
		
		int[] ary = {29,15,14,8,12,26,17,25,50,30,60,55,65,70};
		
		Node<Integer> node = buildTreeFromPreOrderList(ary);
		
		System.out.println();
		//BTreePrinter.printBinaryTree(node,0);
		PrintTreeUsingRecursion.printPreOrder(node);
	}

	private static Node<Integer> buildTreeFromPreOrderList(int[] ary) {
		return rebuildTree(ary,0,ary.length);
	}

	private static Node<Integer> rebuildTree(int[] ary, int start, int end) {
		if(start >= end)
			return null;
		
		int ix = start + 1;
		
		while ( ix < end && ary[start]>ary[ix]) {
			++ix;
		}
		
		Node<Integer> node = new Node<Integer>(ary[start],
				rebuildTree(ary, start+1, ix),
				rebuildTree(ary, ix, end));
		
		return node;
	}

}
