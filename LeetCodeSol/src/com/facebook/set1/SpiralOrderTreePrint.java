package com.facebook.set1;

import java.util.ArrayDeque;
import java.util.Deque;

import com.amazon.Node;

public class SpiralOrderTreePrint {

	public static void main(String[] args) {

		Node<Integer> _1 = new Node<Integer>(1);
		Node<Integer> _2 = new Node<Integer>(2);
		Node<Integer> _3 = new Node<Integer>(3);
		Node<Integer> _4 = new Node<Integer>(4);
		Node<Integer> _5 = new Node<Integer>(5);
		Node<Integer> _6 = new Node<Integer>(6);
		Node<Integer> _7 = new Node<Integer>(7);
		
		_1.left = _2;
		
		_2.left = _7;
		_2.right = _6;
		
		_1.right = _3;
		
		_3.left = _5;
		_3.right = _4;
		
		printSpiral(_1);
		
	}

	private static void printSpiral(Node<Integer> _1) {
		
		Deque<Node<Integer>> queue = new ArrayDeque<>();
		queue.add(_1);
		boolean flag = false;
		
		while(!queue.isEmpty()){

			Deque<Node<Integer>> subQueue = new ArrayDeque<>();
			while(!queue.isEmpty()){
				
				Node<Integer> node = queue.poll();
				System.out.print(node.val+" : ");
				
				if(!flag){
					if (node.left != null)
						subQueue.add(node.left);
					if (node.right != null)
						subQueue.add(node.right);
				}else{
					if (node.left != null)
						subQueue.push(node.left);
					if (node.right != null)
						subQueue.push(node.right);
				}
			}
			
			if(flag){
				flag = false;
			}else{
				flag = true;
			}
				
			
			queue = subQueue;
		}
	}

}
