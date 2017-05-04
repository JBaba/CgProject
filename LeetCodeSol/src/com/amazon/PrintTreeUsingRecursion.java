package com.amazon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import leetcode.sol.tree.BinaryTree;

public class PrintTreeUsingRecursion {

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

			printInOrder(bt.root);
			System.out.println();
			printPreOrder(bt.root);
			System.out.println();
			printPostOrder(bt.root);
	}

	private static void printPostOrder(Node<Integer> root) {
		Deque<Node<Integer>> queue = new ArrayDeque<Node<Integer>>();
		Node<Integer> tree = root;
		List<Integer> list = new ArrayList<>();
		queue.add(tree);
		
		while(!queue.isEmpty()){
			Node<Integer> node = queue.pop();
			list.add(node.val);
			if(node.left.val != null){
				queue.push(node.left);
			}
			
			if(node.right.val != null){
				queue.push(node.right);
			}
		}
		
		System.out.println(list.toString());
	}

	public static void printPreOrder(Node<Integer> root) {
		Deque<Node<Integer>> queue = new ArrayDeque<Node<Integer>>();
		Node<Integer> tree = root;
		
		while (!queue.isEmpty() || (tree != null && tree.val != null)) {
			if(tree != null && tree.val != null){
				System.out.print(tree.val+",");
				if(tree.right != null && tree.right.val != null)
					queue.addFirst(tree.right);
				tree = tree.left;
				
			}else{
				tree = queue.removeFirst();
				if(tree.val != null){
					System.out.print(tree.val+",");
					
					if(tree.right != null && tree.right.val != null)
						queue.addFirst(tree.right);
					
					tree = tree.left;
				}else{
					tree = null;
				}
			}
		}
	}

	private static void printInOrder(Node<Integer> root) {

		Deque<Node<Integer>> queue = new ArrayDeque<Node<Integer>>();
		Node<Integer> tree = root;
		//queue.add(tree);
		
		while (!queue.isEmpty() || tree != null) {
			if(tree != null){
				queue.addFirst(tree);
				tree = tree.left;
			}else{
				tree = queue.removeFirst();
				if(tree.val != null)
					System.out.print(tree.val+",");
				tree = tree.right;
			}
		}
		
	}

}
