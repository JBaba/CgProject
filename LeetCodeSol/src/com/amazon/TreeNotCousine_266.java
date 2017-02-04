package com.amazon;

import java.util.ArrayList;
import java.util.List;

import leetcode.sol.tree.BinaryTree;

public class TreeNotCousine_266 {

	List<Integer> nodes = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		bt.add(5);
		bt.add(4);
		bt.add(6);
		bt.add(7);
		bt.add(8);
		bt.add(12);
		bt.add(17);
		bt.add(50);
		bt.add(30);
		bt.add(60);
		bt.add(25);
		bt.add(55);
		bt.add(65);
		bt.add(70);
		BTreePrinter.printBinaryTree(bt.root,0);
		
		TreeNotCousine_266 ts = new TreeNotCousine_266();
		ts.findNodeWhoDoesntSiblings(bt.root,6);
		ts.findNodeWhoDoesntSiblings(bt.root,10);
		ts.findNodeWhoDoesntSiblings(bt.root,17);
		ts.findNodeWhoDoesntSiblings(bt.root,15);
		ts.findNodeWhoDoesntSiblings(bt.root,53);

		ts.print();
	}

	private void print() {
		System.out.println(nodes);
	}

	private void findNodeWhoDoesntSiblings(Node<Integer> root, int i) {

		if(root == null)
			return;
		
		int heightR = findMaxHeight(root.right);
		int heightL = findMaxHeight(root.left);
		
		//System.out.println("R:"+heightR);
		//System.out.println("L:"+heightL);
		
		if(heightL == heightR){
			return;
		}
		
		//System.out.print("Nodes: ");
		if(heightL > heightR)
			findNodesHigherThenHeight(root.left,heightR,1);
		else
			findNodesHigherThenHeight(root.right,heightL,1);
		//System.out.println();
			
	}

	private void findNodesHigherThenHeight(Node<Integer> left, int heightComp,int height) {
		if(left == null)
			return;
		
		if(height > heightComp){
			if(left.val != null){
				//System.out.print(left.val + " ");
				if(!nodes.contains(left.val))
					nodes.add(left.val);
			}
			findNodeWhoDoesntSiblings(left,53);
			return;
		}
		
		findNodesHigherThenHeight(left.right, heightComp, height+1);
		findNodesHigherThenHeight(left.left, heightComp, height+1);	
	}

	private int findMaxHeight(Node root) {

		if(root == null)
			return -1;
		
		int heightR = findMaxHeight(root.right);
		int heightL = findMaxHeight(root.left);
		
		return Math.max(heightR, heightL)+1;
	}

}
