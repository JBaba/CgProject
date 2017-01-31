package com.amazon;

import leetcode.sol.tree.BinaryTree;

/**
 * 
 * Given a binary tree and a node, print all cousins of given node. Note that siblings should not be printed.
 * 
 * @author nviradia
 *
 */

public class TreeSibling_266 {
	
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
		
		TreeSibling_266 ts = new TreeSibling_266();
		ts.findSiblings(bt.root,6);
		ts.findSiblings(bt.root,10);
		ts.findSiblings(bt.root,17);
		ts.findSiblings(bt.root,15);
		ts.findSiblings(bt.root,53);
	}

	private void findSiblings(Node<Integer> root, int i) {
		
		// find height's of parent for given node
		int siblingsParentHeight = findsiblingsParentHeight(root,i);
		System.out.println("Height : "+siblingsParentHeight);
		
		// if height is < 2 then there is no siblings
		if(siblingsParentHeight < 2){
			System.out.println("No Siblings found.");
			System.out.println("----------------------------------");
			return;
		}
		
		// Edit : No need to find node value can be used to find if its present into left or right node
		// find parent of given node
		Node<Integer> siblingsParent = findsiblingsParent(root,i);
		System.out.println("Node : "+ ((siblingsParent != null) ? siblingsParent.val : "null"));
		
		// if parent is null then no siblings
		if(siblingsParent == null){
			System.out.println("No Siblings found.");
			System.out.println("----------------------------------");
			return;
		}
		
		// find the siblings for given node
		System.out.print("Nodes: ");
		printSiblings(siblingsParent,siblingsParentHeight,1,root);
		System.out.println();
		System.out.println("----------------------------------");
	}

	private void printSiblings(Node<Integer> siblingsParent,int siblingsParentHeight,int height,Node<Integer> root) {
		
		if(root != null){
			
			// its parent of given node
			if(root.val == siblingsParent.val)
				return;
			
			// found the siblings
			if(siblingsParentHeight == height){
				System.out.print(root.left.val + " " + root.right.val);
				return;
			}
			
			// check in the tree
			printSiblings(siblingsParent, siblingsParentHeight, height+1, root.left);
			printSiblings(siblingsParent, siblingsParentHeight, height+1, root.right);
			
		}else{
			return;
		}
		
	}

	private Node<Integer> findsiblingsParent(Node<Integer> root, int i) {
		
		// node not present in the subtree 
		if( (root == null) || (root.left == null) || (root.right == null)){
			return null;
		}
		
		// found the parent of given node
		if((root.left != null && root.left.val == i) || (root.right != null && root.right.val == i)){
			return root;
		}
		
		// check which one has value
		Node<Integer> rightNode = findsiblingsParent(root.right,i);
		Node<Integer> leftNode = findsiblingsParent(root.left,i);
		
		return (rightNode == null) ? leftNode : rightNode;
	}

	private int findsiblingsParentHeight(Node<Integer> root, int i) {
		
		// node not present in the subtree 
		if( (root == null) || (root.left == null) || (root.right == null)){
			return 0;
		}
		
		// found the parent of given node
		if((root.left != null && root.left.val == i) || (root.right != null && root.right.val == i)){
			return 1;
		}
		
		// find height from each sub tree
		int rightH = findsiblingsParentHeight(root.right,i);
		int leftH = findsiblingsParentHeight(root.left,i);
		
		// only return if node present in the sub tree
		return (Math.max(rightH, leftH) > 0) ? Math.max(rightH, leftH)+1 : 0 ;
	}

}
