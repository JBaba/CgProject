package com.epi.design;

import leetcode.sol.tree.BinaryTree;

import com.amazon.BTreePrinter;
import com.amazon.Node;

public class BstTreeValidation {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.add(10);
		bt.add(5);
		bt.add(15);
		bt.add(3);
		bt.add(6);
		bt.add(12);
		bt.add(17);
		bt.add(18);
		bt.add(19);
		BTreePrinter.printBinaryTree(bt.root,0);
		
		NodeBalancedDetails unBalancedNode = isTreeBalanced(bt.root);
		System.out.println(unBalancedNode.isBalanced);
	}

	private static NodeBalancedDetails isTreeBalanced(Node<Integer> root) {
		if(root == null)
			return new NodeBalancedDetails(null,true,-1);
			
		NodeBalancedDetails leftDetails = isTreeBalanced(root.left);
		
		if(!leftDetails.isBalanced)
			return leftDetails;
		
		NodeBalancedDetails rightDetails = isTreeBalanced(root.right);
		
		if(!rightDetails.isBalanced)
			return rightDetails;
		
		if(Math.abs(rightDetails.height-leftDetails.height) > 1){
			if(rightDetails.height>leftDetails.height)
				return new NodeBalancedDetails(root.right, false, rightDetails.height);
			else
				return new NodeBalancedDetails(root.left, false, leftDetails.height);
		}
		
		NodeBalancedDetails details = new NodeBalancedDetails(null, true, Math.max(rightDetails.height, leftDetails.height)+1);
		
		return details;
	}

}

class NodeBalancedDetails {
	
	Node<Integer> node;
	boolean isBalanced;
	int height;
	
	public NodeBalancedDetails(Node<Integer> root, boolean b, int i) {
		node = root;
		isBalanced = b;
		height = i;
	}
	
}
